package com.anudip.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anudip.training.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	
	@Query("SELECT p FROM Payment p WHERE p.bstatus= :bstatus")
    List<Payment> findByStatusContaining(String bstatus);

}
