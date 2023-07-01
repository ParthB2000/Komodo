package com.hlis.exam.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hlis.exam.dto.AdminLoginDto;
import com.hlis.exam.dto.EnableDisableUserDto;
import com.hlis.exam.entity.User;
import com.hlis.exam.response.GenericResponse;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {

	//Admin login API
	@PostMapping("admin/login")
	public ResponseEntity<Object> adminLoginCheck(@RequestBody AdminLoginDto adminLoginDto)
	{
		User user = getServiceRegistry().getUserService().findByEmailAndPasswordAndRoleAndIsActiveAndIsDeleted(adminLoginDto.getEmail(), adminLoginDto.getPassword(), "ADMIN", true, false);
		if(user==null)
		{
			return ResponseEntity.ok(GenericResponse.builder().code(0).message("Invalid Email or Password").build());
		}
		else
		{
			String alphaNumerics = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			Random randomToken = new Random();
			String token = new String();
			for(int i = 0; i<=10 ; i++) 
			{
				token +=  alphaNumerics.charAt(randomToken.nextInt(alphaNumerics.length()));
			}
			user.setToken(token);
			getServiceRegistry().getUserService().save(user);
			return ResponseEntity.ok(GenericResponse.builder().code(1).message("Login Successfully").data(token).build());
		}
	}
	
	//User list API
	@GetMapping("user/list")
	public ResponseEntity<Object> getListOfUsersOfAdmin(HttpServletRequest request)
	{
		String token = request.getHeader("token");
		if(token==null) 
		{
			return ResponseEntity.ok(GenericResponse.builder().code(0).message("Pass token in header").build());
		}
		User checkAdmin = getServiceRegistry().getUserService().findByTokenAndRoleAndIsBlockedAndIsActiveAndIsDeleted(token, "ADMIN", false, true, false);
		if(checkAdmin==null)
		{
			return ResponseEntity.ok(GenericResponse.builder().code(0).message("Pass valid token in header").build());
		}
		List<User> userList = getServiceRegistry().getUserService().findByIsBlockedAndRoleAndIsActiveAndIsDeleted(false, "USER", true, false);
		if(userList.isEmpty())
		{
			return ResponseEntity.ok(GenericResponse.builder().code(2).message("User is not found").build());
		}
		else if(checkAdmin!=null)
		{
			return ResponseEntity.ok(GenericResponse.builder().code(1).message("UserList").data(userList).build());
		}
		return ResponseEntity.ok(GenericResponse.builder().code(2).message("No Data Found").build());
	}
	
	//Enable And Disable User API
	@PostMapping("disable/enable/user")
	public ResponseEntity<Object> enableDisableUser(@RequestBody EnableDisableUserDto enableDisableUserDto, HttpServletRequest request)
	{
		String token = request.getHeader("token");
		if(token==null) 
		{
			return ResponseEntity.ok(GenericResponse.builder().code(0).message("Pass token in header").build());
		}
		User checkAdmin = getServiceRegistry().getUserService().findByTokenAndRoleAndIsBlockedAndIsActiveAndIsDeleted(token, "ADMIN", false, true, false);
		User checkUnBlockedUser = getServiceRegistry().getUserService().findByIdAndRoleAndIsBlockedAndIsActiveAndIsDeleted(enableDisableUserDto.getUser_id(), "USER", false, true, false);
		User checkBlockedUser = getServiceRegistry().getUserService().findByIdAndRoleAndIsBlockedAndIsActiveAndIsDeleted(enableDisableUserDto.getUser_id(), "USER", true, true, false);
		if(checkAdmin==null)
		{
			return ResponseEntity.ok(GenericResponse.builder().code(0).message("Pass valid token in header").build());
		}
		if(enableDisableUserDto.getUser_id() ==0)
		{
			return ResponseEntity.ok(GenericResponse.builder().code(0).message("Pass valid user id").build());
		}
		if(checkAdmin!=null && checkUnBlockedUser!=null)
		{
			checkUnBlockedUser.setIsBlocked(true);
			getServiceRegistry().getUserService().save(checkUnBlockedUser);
			return ResponseEntity.ok(GenericResponse.builder().code(1).message("User Disable Successfully!").build());
		}
		else if(checkAdmin!=null && checkBlockedUser!=null)
		{
			checkBlockedUser.setIsBlocked(false);
			getServiceRegistry().getUserService().save(checkBlockedUser);
			return ResponseEntity.ok(GenericResponse.builder().code(1).message("User Enable Successfully!").build());
		}
		return ResponseEntity.ok(GenericResponse.builder().code(2).message("No Data Found").build());
	}
	
	@PostMapping("/logout")
	public ResponseEntity<Object> adminLogout(HttpServletRequest request)
	{
		String token = request.getHeader("token");
		User checkAdmin = getServiceRegistry().getUserService().findByTokenAndRoleAndIsBlockedAndIsActiveAndIsDeleted(token, "ADMIN", false, true, false);
		if(token==null) 
		{
			return ResponseEntity.ok(GenericResponse.builder().code(0).message("Pass token in header").build());
		}
		else if(token!=checkAdmin.getToken())
		{
			return ResponseEntity.ok(GenericResponse.builder().code(0).message("You are not admin").build());
		}
		else
		{
			checkAdmin.setToken(null);
			getServiceRegistry().getUserService().save(checkAdmin);
			return ResponseEntity.ok(GenericResponse.builder().code(1).message("Logout successfull").build());
		}
//		return ResponseEntity.ok(null);
	}
	
}
