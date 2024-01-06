package com.anudip.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.training.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{

}
