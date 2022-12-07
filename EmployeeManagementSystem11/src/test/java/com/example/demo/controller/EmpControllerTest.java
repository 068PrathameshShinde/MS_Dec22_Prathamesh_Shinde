package com.example.demo.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.morningstar.controller.AdminController;
import com.morningstar.entity.Employee;
import com.morningstar.service.AdminService;

@SpringBootTest(classes=EmpControllerTest.class)
class EmpControllerTest {

	@Mock
	AdminService adminService;
	@InjectMocks 			//checking empController method
	AdminController adminController;
	
	public List<Employee> EmpList;
	
	@Test
	@Order(1)
	public void test_getAllEmp()
	{
		
		EmpList = new ArrayList<>();
		EmpList.add(new Employee(1,"prathamesh","role","prathamesh@gmail.com",23,67000.0,"1234", null));
		EmpList.add(new Employee(2,"prashant","role","prashant@gmail.com",23,67000.0,"1234", null));
		
		when(adminService.getAllEmp()).thenReturn(EmpList);
		ResponseEntity<List<Employee>> res=adminController.getAllEmp();
		
		Assertions.assertEquals(HttpStatus.OK, res.getStatusCode());
		Assertions.assertEquals(2, res.getBody().size());
	}
}
