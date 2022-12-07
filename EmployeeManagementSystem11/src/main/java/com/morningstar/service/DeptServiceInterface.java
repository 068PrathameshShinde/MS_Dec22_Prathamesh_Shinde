package com.morningstar.service;

import java.util.List;

import com.morningstar.entity.Department;

public interface DeptServiceInterface {
	
	public void addDept(Department department);
	public Department findById(int departmentNo);
	public List<Department> getAllEmp();
	
}
