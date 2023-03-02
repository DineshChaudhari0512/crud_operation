package com.saksoft.CRUD_Operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saksoft.CRUD_Operation.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
