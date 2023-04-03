package com.cg.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.dto.BookingDTO;
import com.cg.ems.dto.PaymentDTO;
import com.cg.ems.entity.Payment;
import com.cg.ems.exception.BookingNotFoundException;
import com.cg.ems.exception.PaymentNotFoundException;
import com.cg.ems.service.BookingService;
import com.cg.ems.service.PaymentService;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/payment")
//the base URL path for all the HTTP endpoint
public class PaymentController {
	//constructor injection similar to the service class/layer
	  @Autowired
			private PaymentService paymentService;
      @Autowired
            private BookingService bookingService;
	
      
      
      
			@PostMapping("/addPayment")
			public ResponseEntity<PaymentDTO>addPayment(@RequestBody PaymentDTO paymentDTO)
			
			{
				BookingDTO bookingDTO = bookingService.getByBookingId(paymentDTO.getBookingId());
				
				if(bookingDTO == null)
				{
					throw new BookingNotFoundException("Booking with id " +paymentDTO.getBookingId()+"not exist");
				}
				
				else if (! paymentDTO.getPaymentDate().equals(bookingDTO.getDate()))
				{
					throw new PaymentNotFoundException("Date is not matching");
				}
				
				else if (paymentDTO.getPaymentAmount() != bookingDTO.getTotalCost()) {
					throw new PaymentNotFoundException("Amount is not matching");
					}

				
				PaymentDTO payment = paymentService.savePayment(paymentDTO);
				return ResponseEntity.ok(payment);
			}
			
			
			
			@GetMapping("/{paymentId}")
			public ResponseEntity<PaymentDTO>getPaymentById(@PathVariable long paymentId)
			{
				PaymentDTO paymentDTO=paymentService.getByPaymentId(paymentId);
				return new ResponseEntity<PaymentDTO>(paymentDTO, HttpStatus.FOUND);
			}
			
			@PutMapping("/updatePayment")
			public ResponseEntity<PaymentDTO>updatePayment(@RequestBody PaymentDTO paymentDTO)
			{
				PaymentDTO payment = paymentService.updatePayment(paymentDTO);
				return ResponseEntity.ok(payment);
			}
			
			@DeleteMapping("/deletePaymentById/{paymentID}")
			
			public ResponseEntity<Boolean>deletePaymentById(@PathVariable long paymentId){
				PaymentDTO paymentDTO = paymentService.getByPaymentId(paymentId);
				if(paymentDTO!=null) {
					paymentService.deletePayment(paymentDTO);
					return new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
					
				}
				throw new PaymentNotFoundException("Payment with id "+paymentId +"doesn't exist");
			}
			
			@GetMapping("/getAllPayments")
			public ResponseEntity<List<PaymentDTO>>getAllPaymentDetails()
			{
				List<PaymentDTO> list = paymentService.viewAllPaymentDetails();
				return ResponseEntity.ok(list);
			}
			
			@GetMapping("/paymentByBookingId/{bookingId}")
			public ResponseEntity<PaymentDTO> getPaymentByBooking(@PathVariable int bookingId)
				{
				    
					PaymentDTO payment = paymentService.getPaymentDetailsbyBookingId(bookingId);
					return ResponseEntity.ok(payment);
				}	
			}
			
			
			


