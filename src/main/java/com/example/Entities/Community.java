package com.example.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Community {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String cif;
	private String street;
	private int number;
	private int postalCode;
	private int population;
	private String bankAccount;
	@OneToMany(mappedBy="community")
	private List<Property> communityproperties=new ArrayList<>();
	
	public Community(){}
	
	public Community(String cif, String street, int number, int postalCode, int population, String bankCount) {
		super();
		this.cif = cif;
		this.street = street;
		this.number = number;
		this.postalCode = postalCode;
		this.population = population;
		this.bankAccount = bankCount;
		
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getBankCount() {
		return bankAccount;
	}
	public void setBankCount(String bankCount) {
		this.bankAccount = bankCount;
	}
	public List<Property> getCommunityproperties() {
		return communityproperties;
	}
	public void setCommunityproperties(List<Property> communityproperties) {
		this.communityproperties = communityproperties;
	}
	
	

}
