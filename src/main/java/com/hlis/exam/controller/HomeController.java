package com.hlis.exam.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hlis.exam.dto.LoginDto;
import com.hlis.exam.dto.VerifyUserDto;
import com.hlis.exam.entity.Otp;
import com.hlis.exam.entity.User;

@Controller
public class HomeController extends BaseController {

	//Default landing page
	@GetMapping("/")
	public ModelAndView loadDefaultPage()
	{
		return new ModelAndView("loginotp");
	}
	
	//Load signup page
	@GetMapping("/signup")
	public ModelAndView loadSignupPage()
	{	
		return new ModelAndView("signup");
	}
		
	//Process for signup
	@PostMapping("signup/process")
	public ModelAndView processAddUser(@ModelAttribute User user, Otp otp2) throws JsonProcessingException
	{
		ModelAndView modelAndView = new ModelAndView();
		User chekEmail= getServiceRegistry().getUserService().findByEmailAndIsBlockedAndIsVerifiedAndIsActiveAndIsDeleted(user.getEmail(), false, true, true, false);
		if(chekEmail!=null)
		{
			modelAndView.setViewName("signup");
			modelAndView.addObject("emailExist","Email is already exist!");
			modelAndView.addObject("firstName", user.getFirstName());
			modelAndView.addObject("lastName", user.getLastName());
			modelAndView.addObject("email", user.getEmail());
			return modelAndView;
		}
		String numbers = "1234567890";
		Random random = new Random();
		StringBuilder otp = new StringBuilder();
		for(int i = 0; i<5 ; i++) 
		{
			otp.append(numbers.charAt(random.nextInt(numbers.length())));
		}
		String generatedOTP = otp.toString();
			
		String alphaNumerics = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random randomToken = new Random();
		String token = new String();
		for(int i = 0; i<=10 ; i++) 
		{
			token +=  alphaNumerics.charAt(randomToken.nextInt(alphaNumerics.length()));
		}
		User nonVerifiedUser = getServiceRegistry().getUserService().findByEmailAndIsBlockedAndIsVerifiedAndIsActiveAndIsDeleted(user.getEmail(), false, false, true, false);
		Otp existOtp = getServiceRegistry().getOtpService().findByUserAndIsActiveAndIsDeleted(nonVerifiedUser, true, false);
		if(nonVerifiedUser!=null)
		{
			modelAndView.setViewName("userverify");
			if(existOtp!=null)
			{
				existOtp.setIsActive(false);
				existOtp.setIsDeleted(true);
				getServiceRegistry().getOtpService().save(existOtp);
			}
			nonVerifiedUser.setFirstName(user.getFirstName());
			nonVerifiedUser.setLastName(user.getFirstName());
			nonVerifiedUser.setEmail(user.getEmail());
			nonVerifiedUser.setToken(token);
			getServiceRegistry().getUserService().save(nonVerifiedUser);
			otp2.setOtp(Integer.parseInt(generatedOTP));
			otp2.setUser(nonVerifiedUser);
			getServiceRegistry().getOtpService().save(otp2);
			getServiceRegistry().getEmailServiceImpl().sendSimpleEmail(token, nonVerifiedUser, Integer.parseInt(generatedOTP));
			modelAndView.addObject("successMsg", "Email sent to "+ nonVerifiedUser.getEmail());	
			return modelAndView;
		}
		else
		{
			user.setToken(token);
			otp2.setOtp(Integer.parseInt(generatedOTP));
			otp2.setUser(user);
			getServiceRegistry().getUserService().save(user);
			getServiceRegistry().getOtpService().save(otp2);
			getServiceRegistry().getEmailServiceImpl().sendSimpleEmail(token, user, Integer.parseInt(generatedOTP));
			modelAndView.setViewName("userverify");
			modelAndView.addObject("successMsg","Email Sent to "+user.getEmail());
			return modelAndView;
		}
	}
		
	//Load signup verification page
	@GetMapping("/register/varify")
	public ModelAndView loadVerifyRegisterPage(@RequestParam String id) throws JsonProcessingException
	{
		User user = getServiceRegistry().getUserService().findByIdAndIsActiveAndIsDeleted(Integer.parseInt(id), true, false);
		if(user!=null)
		{
			return new ModelAndView("userverify","id",id);
		}
		return new ModelAndView();
	}
		
	//Process for verify signup via gmail link
	@PostMapping("/register/varify")
	public ModelAndView verifyUser(@ModelAttribute VerifyUserDto verifyUserDto)
	{
		ModelAndView modelAndView = new ModelAndView();
		User user = getServiceRegistry().getUserService().findByIdAndIsActiveAndIsDeleted(verifyUserDto.getId(), true, false);
		Otp otp = getServiceRegistry().getOtpService().findByUserAndIsActiveAndIsDeleted(user, true, false);
		if(user!=null)
		{
			if(otp.getOtp().equals(verifyUserDto.getOtp()) && user.getToken().equals(verifyUserDto.getToken()) )
			{
				modelAndView.setViewName("loginotp");
				user.setIsVerified(true);
				otp.setIsActive(false);
				otp.setIsDeleted(true);
				getServiceRegistry().getOtpService().save(otp);
				getServiceRegistry().getUserService().save(user);
				modelAndView.addObject("success", "Registration successfully!");
				return modelAndView;
			}
			else
			{
				modelAndView.setViewName("userverify");
				modelAndView.addObject("token", verifyUserDto.getToken());
				modelAndView.addObject("otpGet", verifyUserDto.getOtp());
				modelAndView.addObject("error","Invalid otp or token!");
				modelAndView.addObject("id", verifyUserDto.getId());
				return modelAndView;
			}
		}
		return modelAndView;
			
	}
		
	//Load login page
	@GetMapping("send/login/otp")
	public ModelAndView loadLoginPage()
	{
		return new ModelAndView("loginotp");
	}
	
	//Process for sending otp
	@PostMapping("send/login/otp")
	public ModelAndView sendOtpForLogin(@ModelAttribute LoginDto loginDto, RedirectAttributes redirectAttributes)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loginotp");
		User checkEmail = getServiceRegistry().getUserService().findByEmailAndIsVerifiedAndIsActiveAndIsDeleted(loginDto.getEmail(), true, true, false);
		Otp existOtp = getServiceRegistry().getOtpService().findByUserAndIsActiveAndIsDeleted(checkEmail, true, false);
		if(checkEmail!=null)
		{
			if(existOtp!=null)
			{
				existOtp.setIsActive(false);
				existOtp.setIsDeleted(true);
				getServiceRegistry().getOtpService().save(existOtp);
			}
			String numbers = "1234567890";
			Random random = new Random();
			String otp = new String();
			for(int i = 0; i<5 ; i++) 
			{
				otp +=  numbers.charAt(random.nextInt(numbers.length()));
			}
			Otp otp2 = new Otp();
			otp2.setOtp(Integer.parseInt(otp));
			otp2.setUser(checkEmail);
			getServiceRegistry().getOtpService().save(otp2);
			getServiceRegistry().getUserService().save(checkEmail);
			getServiceRegistry().getEmailServiceImpl().sendLoginOtpMail(checkEmail, Integer.parseInt(otp));
			modelAndView.setViewName("verifylogin");
			modelAndView.addObject("successMsgLoginEmail", "Email sent to "+checkEmail.getEmail());
			return modelAndView;
		}
		else
		{
			modelAndView.addObject("email", loginDto.getEmail());
			modelAndView.setViewName("loginotp");
			modelAndView.addObject("errorLogin","Invalid Email!");
			return modelAndView;
		}
	}
		
	//Load login verify page
	@GetMapping("login/verify")
	public ModelAndView loadVerifyLoginPage(@RequestParam String id)
	{
		User user = getServiceRegistry().getUserService().findByIdAndIsActiveAndIsDeleted(Integer.parseInt(id), true, false);
		if(user!=null)
		{
			return new ModelAndView("verifylogin","idLogin",id);
		}
		return new ModelAndView();
		
	}
		
	//Process for login verify via gmail link
	@PostMapping("/login/verify")
	public ModelAndView varifyLoginByOtp(@ModelAttribute VerifyUserDto verifyUserDto, HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		User user = getServiceRegistry().getUserService().findByIdAndIsActiveAndIsDeleted(verifyUserDto.getId(), true, false);
		Otp otp = getServiceRegistry().getOtpService().findByUserAndIsActiveAndIsDeleted(user, true, false);
		if(user!=null)
		{
			if(otp.getOtp().equals(verifyUserDto.getOtp()))
			{
				modelAndView.setViewName("dashboard");
				session.setAttribute("userId", user.getId());
				session.setAttribute("userName", user.getFirstName());
				session.setAttribute("userLastName", user.getLastName());
				session.setAttribute("token", user.getToken());
//				modelAndView.addObject("tokenn", verifyUserDto.getOtp());
				otp.setIsActive(false);
				otp.setIsDeleted(true);
				getServiceRegistry().getOtpService().save(otp);
				modelAndView.addObject("successLogin", "Login successfully!");
				return modelAndView;
			}
			else
			{
				modelAndView.setViewName("verifylogin");
				modelAndView.addObject("otpLogin", verifyUserDto.getOtp());
				modelAndView.addObject("errorLogin", "Invalid otp");
				modelAndView.addObject("idLogin",verifyUserDto.getId());
				return modelAndView;
			}
		}
		return modelAndView;
			
	}
	
	//User logout
	@PostMapping("/logout")
	public ModelAndView logout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.invalidate();
		return new ModelAndView("loginotp");
	}
}
