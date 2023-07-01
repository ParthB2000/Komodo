package com.hlis.exam.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hlis.exam.dto.UpdateSensorDto;
import com.hlis.exam.entity.Boat;
import com.hlis.exam.entity.Sensor;
import com.hlis.exam.entity.User;
import com.hlis.exam.response.GenericResponse;

@Controller
@RequestMapping("/admin")
public class AdminSensorController extends BaseController {

	//Update sensor by admin API
	@PostMapping("update/sensor")
	public ResponseEntity<Object> updateSensor(@RequestBody UpdateSensorDto updateSensorDto, HttpServletRequest request)
	{
		String token = request.getHeader("token");
		if(token==null) 
		{
			return ResponseEntity.ok(GenericResponse.builder().code(0).message("Pass token in header").build());
		}
		Sensor getSensor = getServiceRegistry().getSensorService().findByIdAndIsActiveAndIsDeleted(updateSensorDto.getSensor_id(), true, false);
		User checkAdmin = getServiceRegistry().getUserService().findByTokenAndRoleAndIsBlockedAndIsActiveAndIsDeleted(token, "ADMIN", false, true, false);
		if(checkAdmin==null)
		{
			return ResponseEntity.ok(GenericResponse.builder().code(0).message("Pass valid token in header").build());
		}
		if(updateSensorDto.getSensor_id()==0)
		{
			return ResponseEntity.ok(GenericResponse.builder().code(2).message("No Data Found").build());
		}
		if(checkAdmin!=null && getSensor!=null)
		{
			getSensor.setTemperature(updateSensorDto.getTemperature());
			getSensor.setTempUnit(updateSensorDto.getTemperature_unit());
			getSensor.setHumidity(updateSensorDto.getHumidity());
			getSensor.setPressure(updateSensorDto.getPressure());
			getServiceRegistry().getSensorService().save(getSensor);
			return ResponseEntity.ok(GenericResponse.builder().code(1).message("Sensor Updated Successfully").build());
		}
		return ResponseEntity.ok(GenericResponse.builder().code(2).message("No Data Found").build());
				
	}
			
	//Delete sensor by admin API
	@PostMapping("delete/sensor")
	public ResponseEntity<Object> deleteSensor(@RequestBody UpdateSensorDto updateSensorDto, HttpServletRequest request)
	{
		String token = request.getHeader("token");
		if(token==null)  
		{
			return ResponseEntity.ok(GenericResponse.builder().code(0).message("Pass token in header").build());
		}
		Sensor getSensor = getServiceRegistry().getSensorService().findByIdAndIsActiveAndIsDeleted(updateSensorDto.getSensor_id(), true, false);
		if(getSensor == null) 
		{
			return ResponseEntity.ok(GenericResponse.builder().code(2).message("No Data Found").build());
		}
		User checkAdmin = getServiceRegistry().getUserService().findByTokenAndRoleAndIsBlockedAndIsActiveAndIsDeleted(token, "ADMIN", false, true, false);
		Boat boat = getServiceRegistry().getBoatService().findByIdAndIsActiveAndIsDeleted(getSensor.getBoat().getId(), true, false);
		if(checkAdmin==null)
		{
			return ResponseEntity.ok(GenericResponse.builder().code(0).message("Pass valid token in header").build());
		}
		if(checkAdmin!=null && getSensor!=null)	
		{
			if(boat!=null)
			{
				boat.setHasSensor(false);
				getServiceRegistry().getBoatService().save(boat);
			}
			getSensor.setIsActive(false);
			getSensor.setIsDeleted(true);
			getServiceRegistry().getSensorService().save(getSensor);
			return ResponseEntity.ok(GenericResponse.builder().code(1).message("Sensor Deleted Successfully").build());
		}
		return ResponseEntity.ok(GenericResponse.builder().code(2).message("No Data Found").build());
				
	}
}
