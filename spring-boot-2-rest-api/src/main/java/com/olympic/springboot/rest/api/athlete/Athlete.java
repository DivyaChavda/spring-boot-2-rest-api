package com.olympic.springboot.rest.api.athlete;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

@Entity
public class Athlete {
	@Id
	@GeneratedValue
	private Long ID;
	private String athlete;
	private int age;
	private String country;
	private int year;
	private String date;
	private String sport;
	private int gold;
	private int silver;
	private int bronze;
	private int total;
	
	public Athlete() {
		super();
	}
	
	private Date convertToDate( String date ) throws ParseException {
     DateFormat tmp = new SimpleDateFormat("dd/MM/yyyy");
     return tmp.parse(date);		
	};

	public Athlete(Long iD, String athlete, int total, int gold, String country, int silver, int year, String date,
			String sport, int age, int bronze) throws ParseException {
		super();
		ID = iD;
		this.athlete = athlete;
		this.total = total;
		this.gold = gold;
		this.country = country;
		this.silver = silver;
		this.year = year;
		this.date = date; //convertToDate(date);
		this.sport = sport;
		this.age = age;
		this.bronze = bronze;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getAthlete() {
		return athlete;
	}

	public void setAthlete(String athlete) {
		this.athlete = athlete;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getSilver() {
		return silver;
	}

	public void setSilver(int silver) {
		this.silver = silver;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getBronze() {
		return bronze;
	}

	public void setBronze(int bronze) {
		this.bronze = bronze;
	}
}
