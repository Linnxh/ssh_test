package com.mu.action;

import com.mu.entity.Product;
import com.mu.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction extends ActionSupport implements ModelDriven<Product> {
	// product对象的属性通过ModelDriven从http请求中获取到
	private Product product = new Product();
	ProductService productService;

	// 此需要导入struts2-spring-plugin-2.3.20.jar包
	// 则struts和spring整合实现了按名称自动注入service。
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}

	// 执行保存商品的方法
	public String save() {
		System.out.println("ProductAction.save()方法被执行....");
		if (productService.save(product)) {
			System.out.println("3333...");
		}
		return null;
	}

//	 @Override
//	 public String execute() throws Exception {
//	 // TODO Auto-generated method stub
//	 return SUCCESS;
//	 }
}
