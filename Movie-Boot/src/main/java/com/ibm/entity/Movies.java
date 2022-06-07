package com.ibm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "movies")
public class Movies {
	
	@Id
	private int movie_id;
	@Column(length=20)
	private String movie_name;
	@Column(length=20)
	private int status;
	@Column(length=20)
	private String language;
	@Column(length=20)
	private String genere;
	@Column(length=20)
	private String format;
	@Column(length = 20)
	private String description;
	@Column(length = 20)
	private String imageUrl;
	
	
	//Getters and Setters
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
}
