package com.cg.ems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ems.dto.PaymentDTO;
import com.cg.ems.service.PaymentService;
import com.cg.ems.service.UserService;

@SpringBootTest
class EMSApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private PaymentService paymentService;
	
	@Test 
	void testgetByPaymentId() {
		PaymentDTO p=paymentService.getByPaymentId(15l);
		assertEquals("Failed",p.getPaymentStatus());
	}
	
	@Test 
	void testgetByPaymentstatus() {
		PaymentDTO p2=paymentService.getByPaymentId(15l);
		assertEquals(900,p2.getPaymentAmount());
	}
	
	@Test 
	void testgetByBookingId() {
		PaymentDTO p1=paymentService.getByPaymentId(15l);
		assertEquals(4,p1.getBookingId());
	}
	
	

}
