package com.mu.service;

import java.util.List;

import com.mu.entity.Department;
import com.mu.entity.PageBean;

public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	boolean addDeparment(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
