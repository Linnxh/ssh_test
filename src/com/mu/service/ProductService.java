package com.mu.service;

import org.springframework.transaction.annotation.Transactional;

import com.mu.dao.ProductDao;
import com.mu.entity.Product;

@Transactional//该注解表示注入spring提供的的事务管理
public class ProductService {
	private ProductDao productDao;

	// spring框架中的构造的方式注入bean： productDao
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public boolean save(Product product) {
		System.out.println("ProductService.save()方法被执行....");
		productDao.save(product);
		return true;
	}

}
