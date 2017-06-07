package com.mu.action;

import com.mu.entity.Department;
import com.mu.entity.PageBean;
import com.mu.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

	private Department department = new Department();

	@Override
	public Department getModel() {
		return department;
	}

	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public String findAll() {

		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);

		return "findAll";
	}

	public String add() {
		System.out.println("11111");
		boolean success = departmentService.addDeparment(department);
		if (success) {
			System.out.println("22222");
			return "add";
		} else {
			System.out.println("333333");
			this.addActionError("插入失败");
			return INPUT;
		}
	}

	public String edit() {

		department = departmentService.findById(department.getDid());

		return "editSuccess";
	}

	public String update() {
		departmentService.update(department);
		return "updateSuccess";

	}

	public String delete() {
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";

	}
}
