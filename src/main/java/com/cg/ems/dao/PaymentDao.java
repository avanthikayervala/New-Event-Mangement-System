package com.cg.ems.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cg.ems.entity.Payment;

public interface PaymentDao extends CrudRepository<Payment,Long>{

	Optional<Payment> findByBookingId(Integer bookingId);
	
}
