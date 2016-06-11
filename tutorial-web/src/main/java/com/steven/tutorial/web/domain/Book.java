package com.steven.tutorial.web.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * 学习如何使用GsonBuilder进行json串转换
 * @author liuzhuanghong
 *
 */
public class Book {
	@Expose
	@SerializedName("book_id")  
	private int id;
	@Expose
	private String name;
	private float price;

	public Book() {
	}

	public Book(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public String toString() {
		return "book[id = " + this.id + ", name = " + this.name + ", price = " + this.price + "]";
	}

}
