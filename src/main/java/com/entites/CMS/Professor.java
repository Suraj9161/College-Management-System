package com.entites.CMS;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String email;

	@ManyToMany
	@JoinTable(name = "professor_department", joinColumns = @JoinColumn(name = "professor_id"), inverseJoinColumns = @JoinColumn(name = "department_id"))
	private Set<Department> departments;

	public Professor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Professor(String name, String email, Set<Department> departments) {
		super();
		this.name = name;
		this.email = email;
		this.departments = departments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + ", email=" + email + ", departments=" + departments + "]";
	}
	
	

}
