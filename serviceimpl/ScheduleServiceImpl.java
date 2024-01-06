package com.anudip.training.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.training.entity.Schedule;
import com.anudip.training.exception.RecordsNotFoundException;
import com.anudip.training.model.ScheduleDTO;
import com.anudip.training.repository.ScheduleRepository;
import com.anudip.training.service.ScheduleService;
import com.anudip.training.util.ScheduleConvertor;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	ScheduleRepository srepo;
	
	@Autowired
	ScheduleConvertor sconvertor;
	
	@Override
	public ScheduleDTO addSchedule(Schedule schedule) {
		
		srepo.save(schedule);
	    return sconvertor.convertToScheduleDTO(schedule);
	}

	@Override
	public ScheduleDTO viewScheduleDetails(int scheduleId) {
		
		Schedule schedule = srepo.findById(scheduleId)
                .orElseThrow(() -> new RecordsNotFoundException("Schedule with Id '" + scheduleId + "' Not Found!"));
     return sconvertor.convertToScheduleDTO(schedule);
	}

	@Override
	public ScheduleDTO updateScheduleDetails(Schedule schedule, int scheduleId) {
		
		Schedule updateSchedule = srepo.findById(scheduleId)
                .orElseThrow(() -> new RecordsNotFoundException("Schedule with Id '" + scheduleId + "' not found.."));
		
		updateSchedule.setScheduleId(schedule.getScheduleId());
		updateSchedule.setScheduleId(schedule.getScheduleId());
		updateSchedule.setDriverId(schedule.getDriverId());
		updateSchedule.setStrtPoint(schedule.getStrtPoint());
		updateSchedule.setDestination(schedule.getDestination());
		updateSchedule.setDate(schedule.getDate());
		updateSchedule.setAmt(schedule.getAmt());
				
		return sconvertor.convertToScheduleDTO(srepo.save(updateSchedule));
	}

	@Override
	public void deleteScheduleDetails(int scheduleId) {
		
		srepo.findById(scheduleId)
        .orElseThrow(() -> new RecordsNotFoundException("Schedule with Id '" + scheduleId + "' Not Found!"));
		srepo.deleteById(scheduleId);

	}

	@Override
	public List<ScheduleDTO> getAllSchedules() {
		
		List<Schedule> schedule = srepo.findAll();

        if (schedule.isEmpty()) {
            throw new RecordsNotFoundException("Schedule Records Not Found!");
        }

        return sconvertor.convertToScheduleDTOList(schedule);
	}

}
