package com.mu.dao;

import java.util.List;

import com.mu.entity.Department;
import com.mu.entity.Employee;

public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	boolean addEmployee(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
