package com.ibm.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;


@Entity
@Table(name = "bookings")
public class Bookings {
	
	@Id
	@GeneratedValue
	private int bookingId;
	@Column(length = 20)
	private String bookingDate;
	@Column
	private double price;
	@Column
	private int tickets;
	@JsonIgnore
	@Column
	private double totalcost;
	

	
	@ManyToOne
	@JoinColumn(name = "email")
	private Users user;
		
	@ManyToOne
	@JoinColumn(name = "showId")
	private Shows shows;
	
	
	//Getters and Setters
	
	
	
	public int getBookingId() {
		return bookingId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	public double getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(double totalcost,int tickets, double price) {
		this.totalcost = tickets*price;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Shows getShows() {
		return shows;
	}

	public void setShows(Shows shows) {
		this.shows = shows;
	}


}
