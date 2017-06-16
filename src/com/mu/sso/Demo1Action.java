package com.mu.sso;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//先校验cookie的有效性  在校验登录
public class Demo1Action extends ActionSupport{

	private String gotourl;
	public String main(){
		HttpServletRequest request = ServletActionContext.getRequest();
		boolean ok = SSoCheck.checkcookie(request);
		if(ok){
			return SUCCESS;
		}
		gotourl = "/demo1/main.action";
		return "login";
	}
	public String getGotourl() {
		return gotourl;
	}
	public void setGotourl(String gotourl) {
		this.gotourl = gotourl;
	}
}
