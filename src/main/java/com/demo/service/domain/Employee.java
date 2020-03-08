package com.demo.service.domain;

public class Employee {
	Long id;
	String name;

	public Employee(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}
