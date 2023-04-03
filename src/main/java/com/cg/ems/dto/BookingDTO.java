package com.cg.ems.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class BookingDTO {
	public int bookingId;
//	 @NotNull(message = "Date is required")
//	@JsonProperty("date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date date;
	 //@NotBlank(message = "Total hour is required")
	public int totalHour;
	 //@Min(value = 0, message = "Total cost must be a positive number")
	public double totalCost;
	  // @Min(value = 1, message = "Number of guests must be greater than 0")
	public int noOfGuest;
	
	
	private int eventId;

	private int venueId;
	
	private int foodId;
	private String userName;
	public BookingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookingDTO( Date date, int totalHour, double totalCost, int noOfGuest, int eventId,
			int venueId, int foodId, String userName) {
		super();
		
		this.date = date;
		this.totalHour = totalHour;
		this.totalCost = totalCost;
		this.noOfGuest = noOfGuest;
		this.eventId = eventId;
		this.venueId = venueId;
		this.foodId = foodId;
		this.userName = userName;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTotalHour() {
		return totalHour;
	}
	public void setTotalHour(int totalHour) {
		this.totalHour = totalHour;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public int getNoOfGuest() {
		return noOfGuest;
	}
	public void setNoOfGuest(int noOfGuest) {
		this.noOfGuest = noOfGuest;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "BookingDTO [bookingId=" + bookingId + ", date=" + date + ", totalHour=" + totalHour + ", totalCost="
				+ totalCost + ", noOfGuest=" + noOfGuest + ", eventId=" + eventId + ", venueId=" + venueId + ", foodId="
				+ foodId + ", userName=" + userName + "]";
	}
	
			
		
	}
	
	




