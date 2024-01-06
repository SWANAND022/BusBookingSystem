package com.anudip.training.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.anudip.training.entity.Schedule;
import com.anudip.training.model.ScheduleDTO;

@Component
public class ScheduleConvertor {

	//converting Schedule Entity to Schedule DTO
	
	public ScheduleDTO convertToScheduleDTO(Schedule schedule){
		
		ScheduleDTO sdto = new ScheduleDTO();
		if(schedule != null)
		{
			//copy data from Schedule to ScheduleDTO
			BeanUtils.copyProperties(schedule, sdto);
			
		}
		return sdto;
	}
	
	//converting Schedule dto to Schedule entity
	public Schedule convertToScheduleEntity(ScheduleDTO sdto){
			
			Schedule schedule = new Schedule();
			if(sdto != null)
			{
				//copy data from Schedule to ScheduleDTO
				BeanUtils.copyProperties(sdto,schedule);
				
			}
			return schedule;
		}
	
	 // converting List of Schedule Entities to List of ScheduleDTOs
    public List<ScheduleDTO> convertToScheduleDTOList(List<Schedule> schedules) {
        return schedules.stream()
                .map(this::convertToScheduleDTO)
                .collect(Collectors.toList());
    }
	

}
