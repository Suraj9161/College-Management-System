package com.Dao.CMS;

import com.entites.CMS.Course;

public class CourseDao extends AbstractDao<Course, Long> {
	
	public CourseDao() {
		super(Course.class);
	}
}
