package Entities;

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
	@OneToMany(mappedBy="owner")
	private List<Property> ownerProperties;
	
	
	
	public Owner(String dni, String name, String surname, long numberPhone) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.numberPhone = numberPhone;
		
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
	
	
}
