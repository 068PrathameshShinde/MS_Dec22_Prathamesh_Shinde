package com.morningstar.service;

import java.util.List;
import java.util.Optional;

import com.morningstar.dto.EmployeeAdd;
import com.morningstar.entity.Department;
import com.morningstar.entity.Employee;
import com.morningstar.exceptions.EmployeeNotFounds;
import com.morningstar.exceptions.InvalidLoginDetails;

public interface EmpServiceInterface {
	
	public void addEmp(EmployeeAdd employee);
	public Employee getEmpById(int id) throws  EmployeeNotFounds;
	public String updateEmp(Employee employee,int id) throws  EmployeeNotFounds;
	public String login(Employee employee) throws InvalidLoginDetails;
	
}
