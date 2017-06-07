package com.mu.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mu.dao.DepartmentDao;
import com.mu.dao.EmployeeDao;
import com.mu.entity.Department;
import com.mu.entity.Employee;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);

		return list;
	}

	@Override
	public int findCount() {
		String hql = "select count(*) from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public boolean insertDepartment(Department department) {

		this.getHibernateTemplate().save(department);
		return true;
	}

	@Override
	public Department findById(Integer did) {
	Department department=	this.getHibernateTemplate().get(Department.class, did);
		return department;
	}

	@Override
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
	}

	@Override
	public void delete(Department d) {
		this.getHibernateTemplate().delete(d);
	}

	@Override
	public List<Department> findAll() {
		return this.getHibernateTemplate().find("from Department");
	}

}
