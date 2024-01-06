package com.anudip.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anudip.training.entity.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer >{
	
	@Query("SELECT b FROM Bus b WHERE b.busNo= :busNo")
    List<Bus> findByNoContaining(String busNo);
	
	@Query("SELECT b FROM Bus b WHERE b.type= :type")
	List<Bus>findBytypeContaining  (String type);

}
