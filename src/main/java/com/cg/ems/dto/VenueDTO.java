package com.cg.ems.dto;

public class VenueDTO {
	public int venueId;
	public String venueName;
	public double venueCost;
	public String location;
	public String venueContact;
	public VenueDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VenueDTO(String venueName, double venueCost, String location, String venueContact) {
		super();
		this.venueName = venueName;
		this.venueCost = venueCost;
		this.location = location;
		this.venueContact = venueContact;
	}
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public double getVenueCost() {
		return venueCost;
	}
	public void setVenueCost(double venueCost) {
		this.venueCost = venueCost;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getVenueContact() {
		return venueContact;
	}
	public void setVenueContact(String venueContact) {
		this.venueContact = venueContact;
	}
	@Override
	public String toString() {
		return "VenueDTO [venueId=" + venueId + ", venueName=" + venueName + ", venueCost=" + venueCost + ", location="
				+ location + ", venueContact=" + venueContact + "]";
	}
	
	
}

