package com.example.demo.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.morningstar.entity.Employee;
import com.morningstar.repository.AdminRepository;
import com.morningstar.service.AdminService;
import com.morningstar.service.AdminServiceInterface;

@SpringBootTest(classes= {EmpServiceTest.class})
class EmpServiceTest {

	@Mock
	AdminRepository adminRepository ;
	
	@InjectMocks //checking empService method
	AdminService adminService;
	
	public List<Employee> EmpList;
	
	@Test
	@Order(1)
	public void test_getAllEmp()
	{
		
		EmpList = new ArrayList<>();
		EmpList.add(new Employee(1,"prathamesh","role","prathamesh@gmail.com",23,67000.0,"1234", null));
		EmpList.add(new Employee(2,"prashant","role","prashant@gmail.com",23,67000.0,"1234", null));
		
		when(adminRepository.findAll()).thenReturn(EmpList);
		Assertions.assertEquals(2, adminService.getAllEmp().size());
	}

}
