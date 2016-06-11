/**
 * @author liuzhuanghong
 */
package com.steven.tutorial.web.domain;

import java.io.Serializable;

/**
 * 产品类
 * 
 * @author liuzhuanghong
 *
 */
public class Product implements Serializable {

	private static final long serialVersionUID = -3955477530422890057L;
	private long id;
	private String name;
	private int price;

	public Product() {
	}

	public Product(long id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return "Product[id = " + this.id + ", name = " + this.name + ", price = " + this.price + "]";
	}
}
