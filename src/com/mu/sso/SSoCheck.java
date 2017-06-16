package com.mu.sso;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.StyledEditorKit.BoldAction;

public class SSoCheck {

	public static boolean checkLogin(String username, String pwd) {
		if (username.equals("123") && pwd.equals("123")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkcookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("ssocookie") && cookie.getValue().equals("sso")) {
					return true;
				}
			}
		}
		return false;
	}
}
