package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.demo.service.EmployeeService;

public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DemoAppConfig.class);
		context.getBean(Starter.class).start();

	}
}

@Component
class Starter {

	@Autowired
	EmployeeService employeeService;

	public void start() {

		employeeService.getAllEmployees().forEach(System.out::println);
	}
}
