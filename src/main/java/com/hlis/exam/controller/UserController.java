package com.hlis.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hlis.exam.entity.Boat;
import com.hlis.exam.entity.User;
import com.hlis.exam.response.GenericBoatAndUserResponse;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	//Load dashboard page
	@GetMapping("/dashboard")
	public ModelAndView loadDashboardPage()
	{
		return new ModelAndView("dashboard");
	}
		
	//List of Disabled user
	@GetMapping("users/disable")
	public ModelAndView getListOfDisableUser() 
	{
		List<User> userList = getServiceRegistry().getUserService().findAllByIsBlockedAndIsVerifiedAndIsActiveAndIsDeleted(true, true, true, false);
		if(userList.isEmpty())
			return new ModelAndView("disableuserlist", "errorMessage", "No Data Found!!");
		return new ModelAndView("disableuserlist", "userList", userList);
	}
		
	//List of user with number of boats
	@GetMapping("/list")
	public ModelAndView loadUserList()
	{
		List<User> users = getServiceRegistry().getUserService().findByIsActiveAndIsDeleted(true, false);
		
		List<GenericBoatAndUserResponse> responses = new ArrayList<>();
		for (User user : users) 
		{
			List<Boat> boats = getServiceRegistry().getBoatService().findAllByCreatedByAndIsActiveAndIsDeleted(user, true, false);
			responses.add(new GenericBoatAndUserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole(), user.getIsBlocked(), boats.size()));
		}
		if(responses.isEmpty())
			return new ModelAndView("boatlistofuser", "errorBoatList", "No Data Found!!");
		
		return new ModelAndView("boatlistofuser","boatsWithUsers",responses);
	}
}
