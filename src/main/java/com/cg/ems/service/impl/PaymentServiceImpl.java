package com.cg.ems.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.dao.BookingDao;
import com.cg.ems.dao.PaymentDao;
import com.cg.ems.dto.PaymentDTO;
import com.cg.ems.entity.Payment;
import com.cg.ems.exception.PaymentNotFoundException;
import com.cg.ems.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private BookingDao bookingDao;

	@Override
	public PaymentDTO savePayment(PaymentDTO paymentDTO) {
		Optional<Payment> pay = paymentDao.findByBookingId(paymentDTO.getBookingId());
		if (pay.isPresent()) {
			//bookingId is already exist in payment table its throws the error message
			throw new PaymentNotFoundException("Booking id " + paymentDTO.getBookingId() + "is already payed");
		}
		Payment payment = new Payment();
		BeanUtils.copyProperties(paymentDTO, payment);
		paymentDao.save(payment);
		return paymentDTO;
	}

	@Override
	public PaymentDTO updatePayment(PaymentDTO paymentDTO) {
		// TODO Auto-generated method stub
		Payment payment = new Payment();
		BeanUtils.copyProperties(paymentDTO, payment);
		paymentDao.save(payment);
		return paymentDTO;
	}

	@Override
	public boolean deletePayment(PaymentDTO paymentDTO) {
		// TODO Auto-generated method stub
		Payment payment = new Payment();
		BeanUtils.copyProperties(paymentDTO, payment);
		paymentDao.delete(payment);
		return true;
	}

	@Override
	public PaymentDTO getPaymentDetailsbyBookingId(Integer bookingId) {
		// TODO Auto-generated method stub

		Optional<Payment> payment = paymentDao.findByBookingId(bookingId);
		if (payment.isPresent()) {
			PaymentDTO paymentDTO = new PaymentDTO();
			BeanUtils.copyProperties(payment.get(), paymentDTO);
			return paymentDTO;
		}
		throw new PaymentNotFoundException("Booking with id " + bookingId + "Doesn't exist");
	}

	@Override
	public List<PaymentDTO> viewAllPaymentDetails() {
		// TODO Auto-generated method stub

		Iterable<Payment> list = paymentDao.findAll();
		List<PaymentDTO> dtos = new ArrayList<>();
		for (Payment payment : list) {
			PaymentDTO dto = new PaymentDTO();
			BeanUtils.copyProperties(payment, dto);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public PaymentDTO getByPaymentId(Long paymentId) {
		// TODO Auto-generated method stub

		Optional<Payment> payment = paymentDao.findById(paymentId);
		if (payment.isPresent()) {
			PaymentDTO dto = new PaymentDTO();
			BeanUtils.copyProperties(payment.get(), dto);
			return dto;
		}
		throw new PaymentNotFoundException("Paymnet with  id " + paymentId + "Doesn't exist");
	}

}
