package com.steven.tutorial.web.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;

/**
 * 登录Action
 * 
 * @author liuzhuanghong
 *
 */
@Controller("login")
public class LoginAction {
	private static Map<String, String> userMap = new HashMap<String, String>();
	static {
		userMap.put("liu", "123");
		userMap.put("yang", "456");
	}

	private String username;
	private String password;

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

	public String authority() {
		String curpassword = userMap.get(username);

		if (curpassword != null && curpassword.equals(password)) {
			return "success";
		}

		return "error";
	}
}
