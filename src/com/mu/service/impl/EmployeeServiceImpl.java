package com.mu.service.impl;

import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.mu.dao.EmployeeDao;
import com.mu.entity.Department;
import com.mu.entity.Employee;
import com.mu.entity.PageBean;
import com.mu.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee login(Employee employee) {
		Employee employee2 = employeeDao.findByUsernameAndPassword(employee);
		return employee2;
	}

	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		pageBean.setCurrPage(currPage);
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		int total = employeeDao.findCount();
		pageBean.setTotalCount(total);
		double tc = total;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		int begin = (currPage - 1) * pageSize;
		List<Department> list = employeeDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		boolean succ = employeeDao.addEmployee(employee);
		return succ;
	}

	@Override
	public Employee findById(Integer eid) {
		Employee employee = employeeDao.findById(eid);
		return employee;
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.update(employee);
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.delete(employee);
	}
}
