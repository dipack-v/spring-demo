package com.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.demo.service.domain.Employee;

public class EmployeeService {

	List<Employee> store = Stream.of(new Employee(1L, "Bob"), new Employee(2L, "Sam")).collect(Collectors.toList());

	public List<Employee> getAllEmployees() {
		return store;
	}

}
