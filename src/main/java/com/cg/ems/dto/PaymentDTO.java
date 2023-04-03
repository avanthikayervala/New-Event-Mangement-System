package com.cg.ems.dto;

import java.util.Date;

public class PaymentDTO {

	private long paymentId;

	// @NotBlank(message="the bookingId should not be blanck, empty or null")
	private int bookingId;
	// @NotBlank(message="the amount should not be blanck, empty or null")
	private double paymentAmount;
	// @NotBlank(message="the date should not be blanck, empty or null")
	private Date paymentDate;
	// @NotBlank(message="the status should not be blanck, empty or null")
	private String paymentStatus;

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

}
