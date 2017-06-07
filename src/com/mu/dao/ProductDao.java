package com.mu.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mu.entity.Product;

public class ProductDao extends HibernateDaoSupport{
	public boolean save(Product product) {
		System.out.println("ProductDao.save()方法被执行....");
		// 调用getHibernateTemplate()方法，该方法直接封装了读取配置文件，读取映射文件，创建session工厂，获得session等步骤，简化了我们的操作
		this.getHibernateTemplate().save(product);
		return true;
	}
}
