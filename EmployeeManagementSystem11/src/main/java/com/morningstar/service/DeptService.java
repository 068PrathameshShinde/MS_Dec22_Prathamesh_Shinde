package com.morningstar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morningstar.entity.Department;
import com.morningstar.repository.DeptRepository;

@Service
public class DeptService implements DeptServiceInterface{
	
	@Autowired
	private DeptRepository deptRepository;
	
	public void addDept(Department department)
	{
		deptRepository.save(department);
	}

	public Department findById(int departmentNo) {
		Department d=deptRepository.findById(departmentNo).get();
		return d;
	}
	
	public List<Department> getAllEmp()
	{
		List<Department> list=deptRepository.findAll();
		return list;
	}
	
}
