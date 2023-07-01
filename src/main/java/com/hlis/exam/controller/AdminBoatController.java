package com.hlis.exam.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hlis.exam.dto.UpdateBoatDto;
import com.hlis.exam.entity.Boat;
import com.hlis.exam.entity.Sensor;
import com.hlis.exam.entity.User;
import com.hlis.exam.response.GenericResponse;

@Controller
@RequestMapping("/admin")
public class AdminBoatController extends BaseController {

	//Update boat by admin API
	@PostMapping("/update/boat")
	public ResponseEntity<Object> updateBoat(@RequestBody UpdateBoatDto updateBoatDto, HttpServletRequest request)
	{
		String token = request.getHeader("token");
		if(token==null) 
		{
			return ResponseEntity.ok(GenericResponse.builder().code(0).message("Pass token in header").build());
		}
		Boat getBoat = getServiceRegistry().getBoatService().findByIdAndIsActiveAndIsDeleted(updateBoatDto.getBoatId(), true, false);
		User checkAdmin = getServiceRegistry().getUserService().findByTokenAndRoleAndIsBlockedAndIsActiveAndIsDeleted(token, "ADMIN", false, true, false);
		if(checkAdmin==null)
		{
			return ResponseEntity.ok(GenericResponse.builder().code(0).message("Pass valid token in header").build());
		}
		
		if(updateBoatDto.getBoatId()==0)
		{
			return ResponseEntity.ok(GenericResponse.builder().code(2).message("No Data Found").build());
		}
		if(checkAdmin!=null && getBoat!=null)
		{
			getBoat.setName(updateBoatDto.getBoatName());
			getBoat.setSize(updateBoatDto.getBoatSize());
			getBoat.setCapacity(updateBoatDto.getBoatCapacity());
			getBoat.setUpdatedBy(checkAdmin);
			getServiceRegistry().getBoatService().save(getBoat);
			return ResponseEntity.ok(GenericResponse.builder().code(1).message("Boat Updated Successfully").build());
		}
		else
		{
			return ResponseEntity.ok(GenericResponse.builder().code(2).message("No Data Found").build());
		}
		
//		return ResponseEntity.ok(GenericResponse.builder().code(2).message("No Data Found").build());
				
	}
			
	//Delete boat by admin API
	@PostMapping("delete/boat")
	public ResponseEntity<Object> deleteBoat(@RequestBody UpdateBoatDto updateBoatDto, HttpServletRequest request)
	{
		String token = request.getHeader("token");
		if(token==null) 
		{
			return ResponseEntity.ok(GenericResponse.builder().code(0).message("Pass token in header").build());
		}
		Boat getBoat = getServiceRegistry().getBoatService().findByIdAndIsActiveAndIsDeleted(updateBoatDto.getBoatId(), true, false);
		User checkAdmin = getServiceRegistry().getUserService().findByTokenAndRoleAndIsBlockedAndIsActiveAndIsDeleted(token, "ADMIN", false, true, false);
		Sensor sensor = getServiceRegistry().getSensorService().findByBoatAndIsActiveAndIsDeleted(getBoat, true, false);
		if(checkAdmin==null)
		{
			return ResponseEntity.ok(GenericResponse.builder().code(0).message("Pass valid token in header").build());
		}
		if(updateBoatDto.getBoatId()==0)
		{
			return ResponseEntity.ok(GenericResponse.builder().code(2).message("No Data Found").build());
		}
		if(checkAdmin!=null && getBoat!=null)
		{
			if(sensor!=null)
			{
				sensor.setIsActive(false);
				sensor.setIsDeleted(true);
				getBoat.setHasSensor(false);
			}
			getBoat.setIsActive(false);
			getBoat.setIsDeleted(true);
			getServiceRegistry().getBoatService().save(getBoat);
			return ResponseEntity.ok(GenericResponse.builder().code(1).message("Boat Deleted Successfully").build());
		}
		return ResponseEntity.ok(GenericResponse.builder().code(2).message("No Data Found").build());
				
	}
}
