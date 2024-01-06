package com.anudip.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anudip.training.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	@Query("SELECT a FROM Admin a WHERE a.aname like :aname% order by aname")
    List<Admin> findByNameContaining(String aname);
	
	@Query("SELECT a FROM Admin a WHERE a.userName= :userName")
    List<Admin> findByUserNameContaining(String userName);
}
