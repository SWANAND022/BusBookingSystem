package com.anudip.training.service;

import java.util.List;

import com.anudip.training.entity.Schedule;
import com.anudip.training.model.ScheduleDTO;

public interface ScheduleService {
	
	//For adding new Schedule details/records
			ScheduleDTO addSchedule(Schedule schedule);
			
			//For getting Schedule details/records
			ScheduleDTO viewScheduleDetails(int scheduleId);
			
			//For update Schedule details/records
			ScheduleDTO updateScheduleDetails(Schedule schedule, int scheduleId);
			
			//For deleting existing Schedule details/records
			void deleteScheduleDetails(int scheduleId);
			
			//For getting all Schedule List
			List<ScheduleDTO> getAllSchedules();

}
