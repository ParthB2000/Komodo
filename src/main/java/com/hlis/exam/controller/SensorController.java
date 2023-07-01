package com.hlis.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hlis.exam.dto.SensorAddDto;
import com.hlis.exam.entity.Boat;
import com.hlis.exam.entity.Sensor;
import com.hlis.exam.response.GenericSensorListResponse;

@Controller
public class SensorController extends BaseController {

	//Load page for add sensor
	@GetMapping("add/sensor")
	public ModelAndView loadAddSensor(@RequestParam Integer id)
	{
			return new ModelAndView("sensoradd","id",id);
	}
	
	//Process for add sensor
	@PostMapping("add/sensor")
	public ModelAndView processAddSensor(@ModelAttribute SensorAddDto sensorAddDto)
	{
		Boat boat = getServiceRegistry().getBoatService().findByIdAndIsActiveAndIsDeleted(sensorAddDto.getId(), true, false);
		Sensor existSensor = getServiceRegistry().getSensorService().findByBoatAndIsActiveAndIsDeleted(boat, true, false);
		if(boat!=null)
		{
			if(existSensor!=null)
			{
				return new ModelAndView("boatlistwithusers","alreadyUsed", "Sensor is already added!");
			}
			boat.setHasSensor(true);
			getServiceRegistry().getBoatService().save(boat);
			Sensor sensor = new Sensor();
			sensor.setBoat(boat);
			sensor.setHumidity(sensorAddDto.getHumidity());
			sensor.setName(sensorAddDto.getSensorName());
			sensor.setPressure(sensorAddDto.getPressure());
			sensor.setTemperature(sensorAddDto.getTemperature());
			sensor.setTempUnit(sensorAddDto.getUnit());
			getServiceRegistry().getSensorService().save(sensor);
			
			return new ModelAndView("boatlistwithusers","successfullyAdded", "Sensor Added Successfully");
		}
		
		return new ModelAndView("sensoradd");
	}
	
	//List of sensor with boat details
	@GetMapping("sensor/list")
	public ModelAndView loadSensorList()
	{
		List<Sensor> sensors = getServiceRegistry().getSensorService().findByIsActiveAndIsDeleted(true, false);
		List<GenericSensorListResponse> responses = new ArrayList<>();
		for (Sensor sensor : sensors) 
		{
			responses.add(new GenericSensorListResponse(sensor.getId(), sensor.getName(), sensor.getTemperature(), sensor.getTempUnit(), sensor.getPressure(), sensor.getHumidity(), sensor.getBoat().getName(), sensor.getBoat().getSize(), sensor.getBoat().getCapacity()));
		}
		if(responses.isEmpty())
			return new ModelAndView("sensorlist", "sensorErrorMessage", "No Data Found!!");
		return new ModelAndView("sensorlist","sensorListWithBoat",responses);
	}
	
	//List of sensor which have pressure above 119 with boat details
	@GetMapping("sensor/list/above119")
	public ModelAndView loadSensorListWithPressureMoreThen119()
	{
		List<Sensor> sensors = getServiceRegistry().getSensorService().findByPressureGreaterThanAndIsActiveAndIsDeleted(119.0, true, false);
		List<GenericSensorListResponse> responses = new ArrayList<>();
		for (Sensor sensor : sensors) 
		{
			responses.add(new GenericSensorListResponse(sensor.getId(), sensor.getName(), sensor.getTemperature(), sensor.getTempUnit(), sensor.getPressure(), sensor.getHumidity(), sensor.getBoat().getName(), sensor.getBoat().getSize(), sensor.getBoat().getCapacity()));
		}
		if(responses.isEmpty())
			return new ModelAndView("sensorlist", "sensorErrorMessage", "No Data Found!!");
		return new ModelAndView("sensorlist","sensorListWithBoat",responses);
	}
}
