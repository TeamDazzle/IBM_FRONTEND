package com.ibm.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name = "bookings")
public class Bookings {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int bookingId;
	@Column
	private double cost;
	@Column
	private int tickets;
	@JsonIgnore
	@Column
	private double paid;
	
	@ManyToOne
	@JoinColumn(name = "showId")
	private Shows show;
	
	@OneToOne
	@JoinColumn(name = "email")
	private Users user;
	
	//Getters and Setters
	public Shows getShow() {
		return show;
	}
	public void setShow(Shows show) {
		this.show = show;
	}
	

	public int getBookingId() {
		return bookingId;
	}
	
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getTickets() {
		return tickets;
	}
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	public double getPaid() {
		return paid;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public void setPaid(double paid) {
		this.paid = paid;
	}
	
	
}
	
