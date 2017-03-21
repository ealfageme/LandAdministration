package com.example.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int number;
	private int floor;
	private char letter;
	private double propertyPercent;
	@ManyToOne
	private Owner owner;
	@ManyToOne
	private Community community;
	
	public Property() {}
	public Property(int number, int floor, char letter, double propertyPercent) {
		super();
		this.number = number;
		this.floor = floor;
		this.letter = letter;
		this.propertyPercent = propertyPercent;
		
	}
	public double getPropertyPercent() {
		return propertyPercent;
	}
	public void setPropertyPercent(double propertyPercent) {
		this.propertyPercent = propertyPercent;
	}
	public Community getCommunity() {
		return community;
	}
	public void setCommunity(Community community) {
		this.community = community;
	}
	
	
	
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}

	
	

}

