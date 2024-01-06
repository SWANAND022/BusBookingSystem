package com.anudip.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anudip.training.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("SELECT c FROM Customer c WHERE c.cname like :cname% order by cname")
    List<Customer> findByNameContaining(String cname);
	
	@Query("SELECT c FROM Customer c WHERE c.username= :username")
    List<Customer> findByUserNameContaining(String username);

}
