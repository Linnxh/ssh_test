package com.mu.dao;

import java.util.List;

import com.mu.entity.Department;

public interface DepartmentDao {

	List<Department> findByPage(int begin, int pageSize);

	int findCount();

	boolean insertDepartment(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department d);

	List<Department> findAll();

}
