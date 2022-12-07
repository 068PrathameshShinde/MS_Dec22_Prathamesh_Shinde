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
import com.morningstar.service.EmpService;
import com.morningstar.service.EmpServiceInterface;

import jakarta.validation.Valid;

@RestController
public class EmpController {
	
	private static Logger log=LoggerFactory.getLogger(EmpController.class);
	@Autowired
	private EmpServiceInterface empService;
	
	@PostMapping("/addemp")
	public void addEmp(@Valid @RequestBody EmployeeAdd employee)
	{
		log.info("employee add ");
		empService.addEmp(employee);
	}
	
	@GetMapping("/getempp/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") int id) throws EmployeeNotFounds
	{
		log.info("employee getting by id");
		return new ResponseEntity<Employee>(empService.getEmpById(id),HttpStatus.OK);
	}
	
	
	@PutMapping("updateempp/{id}")
	public ResponseEntity<String> updateEmp(Employee employee,@PathVariable("id") int id) throws EmployeeNotFounds
	{
		log.info("update employee details");
		return new ResponseEntity<String>(empService.updateEmp(employee, id),HttpStatus.OK);
	}
	
	
	
	@PostMapping("/login")
	public ResponseEntity<String> logIn(@Valid @RequestBody Employee employee) throws InvalidLoginDetails //throws InvalidLoginDetails
	{
		log.info("employee log in");
		return new ResponseEntity<String>(empService.login(employee),HttpStatus.OK);
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
