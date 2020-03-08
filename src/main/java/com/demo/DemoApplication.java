package com.demo;

import com.demo.service.EmployeeService;

public class DemoApplication {

	public static void main(String[] args) {
		new Starter().start();
	}
}

class Starter {

	public void start() {
		EmployeeService employeeService = new EmployeeService();
		employeeService.getAllEmployees().forEach(System.out::println);
	}
}