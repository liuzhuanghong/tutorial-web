package com.steven.tutorial.web.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息对象
 */
public class User implements Serializable {

	private static final long serialVersionUID = 9140251156248358636L;

	private int userId;

	private String userName;

	private String password;

	private String lastIp;

	private Date lastVisit;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public Date getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
