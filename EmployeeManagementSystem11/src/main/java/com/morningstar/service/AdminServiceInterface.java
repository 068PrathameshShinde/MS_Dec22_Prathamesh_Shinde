package com.morningstar.service;

import java.util.List;

import com.morningstar.dto.EmployeeAdd;
import com.morningstar.entity.Employee;
import com.morningstar.exceptions.EmployeeNotFounds;

public interface AdminServiceInterface {
	
	public void addEmp(EmployeeAdd employee);
	public Employee getEmpById(int id) throws  EmployeeNotFounds;
	public List<Employee> getAllEmp();
	public String updateEmp(Employee employee,int id) throws  EmployeeNotFounds;
	public String deleteById(int id) throws  EmployeeNotFounds;
}
