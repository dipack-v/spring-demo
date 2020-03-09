package com.demo.repository;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.demo.service.domain.Employee;

@Repository
public class EmployeeRepository {

	List<Employee> store = Stream.of(new Employee(1L, "Bob"), new Employee(2L, "Sam")).collect(Collectors.toList());

	public Employee save(Employee entity) {
		store.add(entity);
		return entity;
	}

	public Employee findById(Long primaryKey) {
		for (Employee e : store) {
			if (e.getId().equals(primaryKey)) {
				return e;
			}
		}
		return null;
	}

	public List<Employee> findAll() {
		return store;
	}

	public long count() {
		return store.size();
	}

	public void delete(Employee entity) {
		Iterator<Employee> it = store.iterator();
		while (it.hasNext()) {
			Employee e = it.next();
			if (e.getId().equals(entity.getId())) {
				it.remove();
			}
		}
	}

}
