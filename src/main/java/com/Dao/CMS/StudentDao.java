package com.Dao.CMS;

import com.entites.CMS.Student;

public class StudentDao extends AbstractDao<Student, Long> {

	public StudentDao() {
		super(Student.class);
	}
}
