package com.steven.tutorial.web.domain;

import java.util.Date;

/**
 * 学生类，用于学习gson
 * 
 * @author liuzhuanghong
 *
 */
public class Student {

	private int id;
	private String name;
	private Date birthDay;

	public Student() {
	}

	public Student(int id, String name, Date birthDay) {
		super();
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "Student [birthDay=" + birthDay + ", id=" + id + ", name=" + name + "]";
	}
}
