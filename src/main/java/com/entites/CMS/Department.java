package com.entites.CMS;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "college_id")
	private College college;

	@OneToMany(mappedBy = "department")
	private Set<Course> courses;
	
	@ManyToMany(mappedBy = "departments")
	private Set<Professor> professors;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department( String name, College college, Set<Course> courses, Set<Professor> professors) {
		super();
		
		this.name = name;
		this.college = college;
		this.courses = courses;
		this.professors = professors;
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

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Set<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(Set<Professor> professors) {
		this.professors = professors;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", college=" + college + ", courses=" + courses
				+ ", professors=" + professors + "]";
	}

	
	
	
}
