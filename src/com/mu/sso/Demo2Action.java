package com.mu.sso;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Demo2Action extends ActionSupport {
	private String gotourl;

	public String main() {
		HttpServletRequest request = ServletActionContext.getRequest();
		boolean ok = SSoCheck.checkcookie(request);
		if (ok) {
			return SUCCESS;
		}
		gotourl = "${pageContext.request.contextPath}" + "/demo2/main.action";
		return "login";
	}

	public String getGotourl() {
		return gotourl;
	}

	public void setGotourl(String gotourl) {
		this.gotourl = gotourl;
	}
}
