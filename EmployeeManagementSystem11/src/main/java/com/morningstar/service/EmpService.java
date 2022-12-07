package com.morningstar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morningstar.dto.EmployeeAdd;
import com.morningstar.entity.Department;
import com.morningstar.entity.Employee;
import com.morningstar.exceptions.EmployeeNotFounds;
import com.morningstar.exceptions.InvalidLoginDetails;
import com.morningstar.repository.EmpRepository;


@Service
public class EmpService implements EmpServiceInterface{
	
	@Autowired
	private EmpRepository emp;
	@Autowired
	private DeptService deptService;
	
	public void addEmp(EmployeeAdd employee)
	{
		Employee e=new Employee();
		
		e.setAge(employee.getAge());
		e.setEmail(employee.getEmail());
		e.setName(employee.getName());
		e.setRole(employee.getRole());
		e.setSalary(employee.getSalary());
		e.setPassword(employee.getPassword());
	   Department d=deptService.findById(employee.getDepartmentNo());
		
		e.setDepartment(d);
		emp.save(e);
	}
	
	public Employee getEmpById(int id) throws EmployeeNotFounds
	{
		
		if(emp.findById(id).isEmpty())
		{
			throw new EmployeeNotFounds();
		}
		else
		{
		 return	emp.findById(id).get();
		}
		
	}
	
	
	
	public String updateEmp(Employee employee,int id) throws EmployeeNotFounds
	{
		Optional<Employee> employee1=emp.findById(id);
		
		 String name=employee.getName();
		 String role=employee.getRole();
		 String email=employee.getEmail();
		 int age=employee.getAge();
		 double salary=employee.getSalary();
		 Department dept=employee.getDepartment();
		 
		Employee employee2;
		 
		if(employee1.isPresent())
		{
			employee2=employee1.get();
			if(name != null)
			{
				employee2.setName(name);
			}
			if(role!=null)
			{
				employee2.setRole(role);
			}
			if(email!=null) 
			{
				employee2.setEmail(email);
			}
			if(age!=0)
			{
				employee2.setAge(age);
			}
			if(salary!=0.0)
			{
				employee2.setSalary(salary);
			}
			if(dept!=null)
			{
				employee2.setDepartment(dept);
			}
			emp.save(employee2);
			return "employee updated successfully";
		}
		else
		{
			throw new EmployeeNotFounds();
		}
		
	}
	
	
	public String login(Employee employee) throws InvalidLoginDetails
	{
		String mail=employee.getEmail();
		String password=employee.getPassword();
		
		Employee employee1=emp.findEmployee(mail, password);
		if(employee1!=null)
		{
			return "employee login successfully";
		}
		else
		{
			throw new InvalidLoginDetails();
		}
		
	}
}
