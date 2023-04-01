package com.saksoft.CRUD_Operation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saksoft.CRUD_Operation.entity.Employee;
import com.saksoft.CRUD_Operation.exception.ResourceNotFoundException;
import com.saksoft.CRUD_Operation.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	 public Employee addEmployee(Employee employee) {
	        return employeeRepository.save(employee);
	    }

	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee is not availbel ->" + "" + id));
	}
	
	 public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }
	
	public Employee updateEmployeeById(Employee employee, Long id) {
		Employee employeeRecord= employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee is not availbel ->" + "" + id));
		employeeRecord.setFirstName(employee.getFirstName());
		employeeRecord.setLastName(employee.getLastName());
		employeeRecord.setEmail(employee.getEmail());
		employeeRecord.setAge(employee.getAge());
		
		return employeeRepository.save(employeeRecord);
		
	}
	  public void deleteEmployeeById(Long id) {
		  employeeRepository.deleteById(id);
	    }
	
	
	
	
	
	
}
