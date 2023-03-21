package com.saksoft.CRUD_Operation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saksoft.CRUD_Operation.entity.Employee;
import com.saksoft.CRUD_Operation.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
  //employee controller
	@Autowired
	EmployeeService employeeService;
	 @PostMapping("/employee")
	    public Employee createEmployee(@RequestBody Employee employee) {
	        return employeeService.createEmployee(employee);
	    }
	 @GetMapping("/{id}")
	    public Employee getEMployeeById(@PathVariable Long id) {
	        return employeeService.getEmployeeById(id);
	    }
	 @GetMapping("")
	    public List<Employee> getAllEmployee() {
	        return employeeService.getAllEmployee();
	    }
	 
	 @PutMapping("/{id}")
	 public Employee updateEmployeeById(@PathVariable Long id, Employee employee) {
		 return employeeService.updateEmployeeById(employee, id);
	 }
	 
	 @DeleteMapping("/{id}")
	    public void deleteEmployee(@PathVariable Long id) {
		 employeeService.deleteEmployee(id);
	    }
}
