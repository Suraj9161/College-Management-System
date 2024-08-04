package com.Dao.CMS;

import com.entites.CMS.Department;

public class DepartmentDao extends AbstractDao<Department, Long> {
	
	public DepartmentDao() {
		super(Department.class);
	}
}
