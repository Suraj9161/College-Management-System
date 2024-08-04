package com.entites.CMS;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Course {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private int cerdits;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	@ManyToMany(mappedBy = "courses")
	private Set<Student> students=new HashSet<>();;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String name, int cerdits, Department department, Set<Student> students) {
		super();
		this.name = name;
		this.cerdits = cerdits;
		this.department = department;
		this.students = students;
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

	public int getCerdits() {
		return cerdits;
	}

	public void setCerdits(int cerdits) {
		this.cerdits = cerdits;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", cerdits=" + cerdits + ", department=" + department
				+ ", students=" + students + "]";
	}
	
	
}
