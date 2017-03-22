package com.example.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String dni;
	private String name;
	private String surname;
	private long numberPhone;
	private String bankAccount;
	@OneToMany(mappedBy="owner")
	private List<Property> ownerProperties=new ArrayList<>();
	
	public Owner(){}
	
	public Owner(String dni, String name, String surname, long numberPhone, String bankAccount) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.numberPhone = numberPhone;
		this.bankAccount =  bankAccount;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDNI() {
		return dni;
	}
	public void setDNI(String dNI) {
		dni = dNI;
	}
	public String getName() {
		return name;
	}
	public void setName(String propertyName) {
		this.name = propertyName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String propertySurname) {
		this.surname = propertySurname;
	}
	public long getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(long numberPhone) {
		this.numberPhone = numberPhone;
	}
	public List<Property> getOwnerProperties() {
		return ownerProperties;
	}
	public void setOwnerProperties(List<Property> ownerProperties) {
		this.ownerProperties = ownerProperties;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	
	
	
}
