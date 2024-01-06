package com.anudip.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anudip.training.entity.Driver;


public interface DriverRepository extends JpaRepository<Driver, Integer>{
	
	@Query("SELECT d FROM Driver d WHERE d.dname like :dname% ORDER BY dname")
    List<Driver> findByNameContaining(String dname);
	
	@Query("SELECT d FROM Driver d WHERE d.dcontact= :dcontact")
	List<Driver>findByContactContaining(long dcontact);

}
