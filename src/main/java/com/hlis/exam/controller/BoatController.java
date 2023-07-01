package com.hlis.exam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hlis.exam.entity.Boat;
import com.hlis.exam.entity.User;
import com.hlis.exam.response.GenericBoatListResponse;

@Controller
public class BoatController extends BaseController {

	//Load page for boat add
	@GetMapping("/add/boat")
	public ModelAndView loadAddBoat()
	{
		return new ModelAndView("boat");
	}
	
	//Process for boat add
	@PostMapping("/add/boat")
	public ModelAndView processAddBoat(@ModelAttribute Boat boat, HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView modelAndView = new ModelAndView();
		HttpSession  session = request.getSession();
		Integer id = (Integer) session.getAttribute("userId");
		User user = getServiceRegistry().getUserService().findByIdAndIsActiveAndIsDeleted(id, true, false);
		
		if(user!=null)
		{
			boat.setCreatedBy(user);
			boat.setUpdatedBy(user);
			getServiceRegistry().getBoatService().save(boat);
			modelAndView.addObject("boatId", boat.getId());
			modelAndView.setViewName("boatlistofuser");
			modelAndView.addObject("successMessage", "Boat added successfull");
			return modelAndView;
		}
		else
		{
			return new ModelAndView("boat");
		}
	}
	
	//List of boat with basic details of user
	@GetMapping("boat/list")
	public ModelAndView loadBoatList()
	{
		List<Boat> boats = getServiceRegistry().getBoatService().findByIsActiveAndIsDeleted(true, false);
		List<GenericBoatListResponse> responses = new ArrayList<>();
		
		for (Boat boat : boats) 
		{
			responses.add(new GenericBoatListResponse(boat.getId(), boat.getName(), boat.getSize(), boat.getCapacity(), boat.getCreatedBy().getFirstName(), boat.getCreatedBy().getLastName(), boat.getCreatedBy().getEmail(), boat.getHasSensor()));
		}
		if(responses.isEmpty())
			return new ModelAndView("boatlistwithusers", "errorBoatUserList", "No Data Found!!");
		return new ModelAndView("boatlistwithusers","boatsListWithUser",responses);
	}
	
	//List of boat with sensor filter with basic details of user
	@GetMapping("boat/list/with/sensor")
	public ModelAndView loadBoatListWithSensor()
	{
		List<Boat> boats = getServiceRegistry().getBoatService().findByHasSensorAndIsActiveAndIsDeleted(true, true, false);
		List<GenericBoatListResponse> responses = new ArrayList<>();
		for (Boat boat : boats) 
		{
			responses.add(new GenericBoatListResponse(boat.getId(), boat.getName(), boat.getSize(), boat.getCapacity(), boat.getCreatedBy().getFirstName(), boat.getCreatedBy().getLastName(), boat.getCreatedBy().getEmail(), boat.getHasSensor()));
		}
		if(responses.isEmpty())
			return new ModelAndView("boatlistwithusers", "errorBoatUserList", "No Data Found!!");
		return new ModelAndView("boatlistwithusers","boatsListWithUser",responses);
	}
	
	//List of boat without sensor filter with basic details of user
	@GetMapping("boat/list/without/sensor")
	public ModelAndView loadBoatListWithoutSensor()
	{
		List<Boat> boats = getServiceRegistry().getBoatService().findByHasSensorAndIsActiveAndIsDeleted(false, true, false);
		List<GenericBoatListResponse> responses = new ArrayList<>();
		for (Boat boat : boats) 
		{
			responses.add(new GenericBoatListResponse(boat.getId(), boat.getName(), boat.getSize(), boat.getCapacity(), boat.getCreatedBy().getFirstName(), boat.getCreatedBy().getLastName(), boat.getCreatedBy().getEmail(), boat.getHasSensor()));
		}
		if(responses.isEmpty())
			return new ModelAndView("boatlistwithusers", "errorBoatUserList", "No Data Found!!");
		return new ModelAndView("boatlistwithusers","boatsListWithUser",responses);
	}
	
}
