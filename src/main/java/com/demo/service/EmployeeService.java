package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.repository.EmployeeRepository;
import com.demo.service.domain.Employee;

@Service
public class EmployeeService {

	EmployeeRepository employeeRepository;
	

	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

}
