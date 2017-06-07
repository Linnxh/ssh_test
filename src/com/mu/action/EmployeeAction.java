package com.mu.action;

import java.util.List;

import com.mu.entity.Department;
import com.mu.entity.Employee;
import com.mu.entity.PageBean;
import com.mu.service.DepartmentService;
import com.mu.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {

	private Employee employee = new Employee();

	private EmployeeService employeeService;
	private DepartmentService departmentService;
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	public Employee getModel() {
		return employee;
	}

	public String login() {

		System.out.println("login执行了");

		Employee existEmployee = employeeService.login(employee);
		if (existEmployee == null) {
			this.addActionError("用户名或密码错误");
			return INPUT;
		} else {
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}

	}

	public String findAll() {
		PageBean<Department> pageBean = employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		System.out.println("sssss执行了");
		return "findAll";
	}

	public String saveUI() {
		List<Department> list = departmentService.findAll();
		if (list.size() > 0) {
			ActionContext.getContext().getValueStack().set("list", list);
		}
		return "saveUI";
	}

	public String add() {
		boolean success = employeeService.addEmployee(employee);
		return "add";
	}

	public String edit() {
		employee = employeeService.findById(employee.getEid());
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "edit";
	}

	public String update() {
		System.out.println(employee.getEname());
		employeeService.update(employee);
		return "updateSuccess";
	}

	public String delete() {
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}

}
