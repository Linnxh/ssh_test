package com.mu.service;

import com.mu.entity.Department;
import com.mu.entity.Employee;
import com.mu.entity.PageBean;

public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Department> findByPage(Integer currPage);

	boolean addEmployee(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
