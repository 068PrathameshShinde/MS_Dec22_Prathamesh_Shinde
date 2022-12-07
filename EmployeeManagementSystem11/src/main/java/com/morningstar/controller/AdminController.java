package com.morningstar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.morningstar.dto.EmployeeAdd;
import com.morningstar.entity.Employee;
import com.morningstar.exceptions.EmployeeNotFounds;
import com.morningstar.exceptions.InvalidLoginDetails;
import com.morningstar.service.AdminServiceInterface;
import com.morningstar.service.EmpServiceInterface;

import jakarta.validation.Valid;

@RestController
public class AdminController {
	
	private static Logger log=LoggerFactory.getLogger(EmpController.class);
	@Autowired
	private AdminServiceInterface adminService;
	
	@PostMapping("/addempp")
	public void addEmp(@Valid @RequestBody EmployeeAdd employee)
	{
		log.info("employee add ");
		adminService.addEmp(employee);
	}
	
	@GetMapping("/getemp/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") int id) throws EmployeeNotFounds
	{
		log.info("employee getting by id");
		return new ResponseEntity<Employee>(adminService.getEmpById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getallemp")
	public ResponseEntity<List<Employee>> getAllEmp()
	{
		log.info("get all employees ");
		 List<Employee> list =adminService.getAllEmp();	
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}
	
	@PutMapping("updateemp/{id}")
	public ResponseEntity<String> updateEmp(@RequestBody Employee employee,@PathVariable("id") int id) throws EmployeeNotFounds
	{
		log.info("update employee details");
		return new ResponseEntity<String>(adminService.updateEmp(employee, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteemp/{id}")
	public ResponseEntity<String> delteById(@PathVariable int id) throws EmployeeNotFounds
	{
		log.info("delete employee details");
		return new ResponseEntity<String>(adminService.deleteById(id),HttpStatus.OK);
	}
	

	   @ResponseStatus(HttpStatus.BAD_REQUEST)
	   @ExceptionHandler(MethodArgumentNotValidException.class)
	   public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) 
	   {
	       Map<String, String> errors = new HashMap<>();

	       ex.getBindingResult().getFieldErrors().forEach(error ->
	               errors.put(error.getField(), error.getDefaultMessage()));
	       return errors;
	   }
}
