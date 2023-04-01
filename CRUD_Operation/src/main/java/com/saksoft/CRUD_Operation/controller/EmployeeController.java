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
@RequestMapping("/employee")
public class EmployeeController {
 
	@Autowired
	EmployeeService employeeService;
	 @PostMapping("/new")
	    public Employee addNewEmployee(@RequestBody Employee employee) {
	        return employeeService.addEmployee(employee);
	    }
	 @GetMapping("/{id}")
	    public Employee getEmployeeById(@PathVariable Long id) {
	        return employeeService.getEmployeeById(id);
	    }
	 @GetMapping("/all")
	    public List<Employee> getAllEmployees() {
	        return employeeService.getAllEmployees();
	    }
	 
	 @PutMapping("/{id}")
	 public Employee updateEmployeeById(@PathVariable Long id, Employee employee) {
		 return employeeService.updateEmployeeById(employee, id);
	 }
	 
	 @DeleteMapping("/{id}")
	    public void deleteEmployeeById(@PathVariable Long id) {
		 employeeService.deleteEmployeeById(id);
	    }
}
