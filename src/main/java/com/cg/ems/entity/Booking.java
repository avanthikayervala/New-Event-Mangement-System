package com.cg.ems.entity;

import java.io.Serializable;
import java.util.Date;

import com.cg.ems.entity.Event;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity

public class Booking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int bookingId;
	public Date date;
	public int totalHour;
	public double totalCost;
	public int noOfGuest;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_id")
	private Event event;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "venue_id")
	private Venue venue;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "food_id")
	private FoodItems foodItems;
	@OneToOne(mappedBy = "booking")

	//private Payment payment;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_name")
	private User user;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(Date date, int totalHour, double totalCost, int noOfGuest, Event event, Venue venue,
			FoodItems foodItems, Payment payment, User user) {
		super();
		this.date = date;
		this.totalHour = totalHour;
		this.totalCost = totalCost;
		this.noOfGuest = noOfGuest;
		this.event = event;
		this.venue = venue;
		this.foodItems = foodItems;
		//this.payment = payment;
		this.user = user;
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

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public FoodItems getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(FoodItems foodItems) {
		this.foodItems = foodItems;
	}

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", date=" + date + ", totalHour=" + totalHour + ", totalCost="
				+ totalCost + ", noOfGuest=" + noOfGuest + ", event=" + event + ", venue=" + venue + ", foodItems="
				+ foodItems + ", user=" + user + "]";
	}


//
//	@Override
//	public String toString() {
//		return "Booking [bookingId=" + bookingId + ", date=" + date + ", totalHour=" + totalHour + ", totalCost="
//				+ totalCost + ", noOfGuest=" + noOfGuest + ", event=" + event + ", venue=" + venue + ", foodItems="
//				+ foodItems + ", payment=" + payment + ", user=" + user + "]";
//	}

}
