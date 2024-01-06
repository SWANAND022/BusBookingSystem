package com.anudip.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.training.entity.Schedule;
import com.anudip.training.model.ScheduleDTO;
import com.anudip.training.service.ScheduleService;
import com.anudip.training.util.ScheduleConvertor;

@RestController
@RequestMapping("/Schedule")
public class ScheduleController {
	
	@Autowired
	ScheduleService ss;
	
	@Autowired
	ScheduleConvertor sconvertor;
	
	@PostMapping("/saveSchedule")
	public ScheduleDTO saveSchedule(@RequestBody ScheduleDTO sdto)
	{
		
		Schedule schedule1 = sconvertor.convertToScheduleEntity(sdto);
		
		return ss.addSchedule(schedule1);
	}
	
	@GetMapping("/getScheduleDetails/{scheduleId}")
	public ScheduleDTO getScheduleDetails(@PathVariable("scheduleId") int scheduleId)
	{
		return ss.viewScheduleDetails(scheduleId);

	}
	
	@PutMapping("/editScheduleDetails/{scheduleId}")
	public ScheduleDTO editScheduleDetails(@PathVariable("scheduleId")int scheduleId,@RequestBody ScheduleDTO sdto)
	{
		Schedule schedule1 = sconvertor.convertToScheduleEntity(sdto);
        return ss.updateScheduleDetails(schedule1, scheduleId);

	}

	@DeleteMapping("/deleteScheduleDetails/{scheduleId}")
	public ResponseEntity<String> deleteScheduleDetails(@PathVariable("scheduleId") int scheduleId)
	{
		ss.deleteScheduleDetails(scheduleId);
		return new ResponseEntity<String>("deleted Successfully..",HttpStatus.OK);
	}
	
	@GetMapping("/getAllSchedules")
    public List<ScheduleDTO>  getAllSchedules() {
		
        return ss.getAllSchedules();
    }


}
