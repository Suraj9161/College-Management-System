package com.entites.CMS;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String name;
	    private String email;

	    @ManyToMany
	    @JoinTable(name = "Student_course",joinColumns = @JoinColumn(name="student_id"),inverseJoinColumns = @JoinColumn(name="course_id"))
	    private Set<Course> courses=new HashSet<>();;

		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Student( String name, String email, Set<Course> courses) {
			super();
			
			this.name = name;
			this.email = email;
			this.courses = courses;
		}

		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", email=" + email + ", courses=" + courses + "]";
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

		public Set<Course> getCourses() {
			return courses;
		}

		public void setCourses(Set<Course> courses) {
			this.courses = courses;
		}
	    
	    

}
