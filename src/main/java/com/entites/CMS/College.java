package com.entites.CMS;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String address;

	@Column(name = "collage_email")
	private String email;

	private Date establishedDate;


	@Column(name = "collage_Number")
	private long mobileNumber;

	@Column(name = "Clg_code")
	private String collageCode;
	
	@OneToMany(mappedBy = "college")
	private Set<Department> departments;
	
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

	public College(String name, String address, String email, Date establishedDate, long mobileNumber,
			String collageCode, Set<Department> departments) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.establishedDate = establishedDate;
		this.mobileNumber = mobileNumber;
		this.collageCode = collageCode;
		this.departments = departments;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEstablishedDate() {
		return establishedDate;
	}

	public void setEstablishedDate(Date establishedDate) {
		this.establishedDate = establishedDate;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCollageCode() {
		return collageCode;
	}

	public void setCollageCode(String collageCode) {
		this.collageCode = collageCode;
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

}
