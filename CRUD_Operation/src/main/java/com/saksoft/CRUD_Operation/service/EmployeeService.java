package com.saksoft.CRUD_Operation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saksoft.CRUD_Operation.entity.Employee;
import com.saksoft.CRUD_Operation.exception.ResourceNotFoundException;
import com.saksoft.CRUD_Operation.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	 public Employee createEmployee(Employee employee) {
	        return employeeRepository.save(employee);
	    }

	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee is not availbel ->" + "" + id));
	}
	
	 public List<Employee> getAllEmployee() {
	        return employeeRepository.findAll();
	    }
	
	public Employee updateEmployeeById(Employee employee, Long id) {
		Employee empl = employeeRepository.findById(id).get();
		empl.setFirstName(employee.getFirstName());
		empl.setLastName(employee.getLastName());
		empl.setEmail(employee.getEmail());
		empl.setAge(employee.getAge());
		
		return employeeRepository.save(empl);
		
	}
	  public void deleteEmployee(Long id) {
		  employeeRepository.deleteById(id);
	    }
	
	
	
	
	
	
}
