package com.mu.service.impl;

import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.mu.dao.DepartmentDao;
import com.mu.entity.Department;
import com.mu.entity.PageBean;
import com.mu.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public PageBean<Department> findByPage(Integer currPage) {

		PageBean<Department> pageBean = new PageBean<Department>();
		pageBean.setCurrPage(currPage);
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		int total = departmentDao.findCount();
		pageBean.setTotalCount(total);
		double tc = total;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public boolean addDeparment(Department department) {
		boolean success = departmentDao.insertDepartment(department);
		return success;
	}

	@Override
	public Department findById(Integer did) {
		Department department = departmentDao.findById(did);
		return department;
	}

	@Override
	public void update(Department department) {
		departmentDao.update(department);
		
	}

	@Override
	public void delete(Department d) {
		// TODO Auto-generated method stub
		departmentDao.delete(d);
	}

	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

}
