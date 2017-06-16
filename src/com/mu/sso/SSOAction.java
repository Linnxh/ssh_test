package com.mu.sso;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class SSOAction extends ActionSupport {

	private String username;
	private String password;
	private String gotourl;

	public String dologin() {

		boolean ok = SSoCheck.checkLogin(username, password);
		if (ok) {
			Cookie cookie = new Cookie("ssocookie", "sso");
			cookie.setPath("/");// 设置到顶层
			HttpServletResponse response = ServletActionContext.getResponse();
			response.addCookie(cookie);
			return SUCCESS;
		} else {
			return "login";
		}

	}

	public void setGotourl(String gotourl) {
		this.gotourl = gotourl;
	}

	public String getGotourl() {
		return gotourl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
