package com.morningstar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.morningstar.entity.Department;
import com.morningstar.service.DeptService;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@PostMapping("/adddept")
	public void addDept( Department department)
	{
		deptService.addDept(department);
	}
	
	@GetMapping("/getalldept")
	public List<Department> getAllDept()
	{
		return deptService.getAllEmp();
	}
}
