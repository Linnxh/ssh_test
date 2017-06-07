package com.mu.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mu.dao.EmployeeDao;
import com.mu.entity.Department;
import com.mu.entity.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql = "from Employee where username = ? and password = ?";

		List<Employee> list = this.getHibernateTemplate().find(hql, employee.getUsername(), employee.getPassword());
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Department> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);

		return list;
	}

	@Override
	public int findCount() {
		String hql = "select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		this.getHibernateTemplate().save(employee);
		return true;
	}

	@Override
	public Employee findById(Integer eid) {
		Employee employee = this.getHibernateTemplate().get(Employee.class, eid);
		return employee;
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("EmployeeDaoImpl---"+employee.getEname());
		this.getHibernateTemplate().update(employee);
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(employee);
	}

}
