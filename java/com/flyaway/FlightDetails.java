package com.flyaway;

import java.sql.Time;

public class FlightDetails {

	private double price;
	private String airline;
	private String flight_no;
	private Time duration;

	public FlightDetails() {
		
	}
	public FlightDetails(double price, String airline, String flight_no, Time duration) {
		this.price = price;
		this.airline = airline;
		this.flight_no = flight_no;
		this.duration = duration;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getFlight_no() {
		return flight_no;
	}
	public void setFlight_no(String flight_no) {
		this.flight_no = flight_no;
	}
	public Time getDuration() {
		return duration;
	}
	public void setDuration(Time duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "FlightDetails [price=" + price + ", airline=" + airline + ", flight_no=" + flight_no
				+ ", duration=" + duration + "]";
	}
}
