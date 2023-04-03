package com.cg.ems.service;

import java.util.List;

import com.cg.ems.dto.PaymentDTO;

public interface PaymentService {
	
	
	public PaymentDTO savePayment(PaymentDTO paymentDTO);

	public PaymentDTO updatePayment(PaymentDTO paymentDTO);

	public boolean deletePayment(PaymentDTO paymentDTO);

	//public PaymentDTO getPaymentDetailsbyBookingId(Long paymentId);


	public List<PaymentDTO> viewAllPaymentDetails();

	PaymentDTO getByPaymentId(Long paymentId);

	PaymentDTO getPaymentDetailsbyBookingId(Integer bookingId);
}
