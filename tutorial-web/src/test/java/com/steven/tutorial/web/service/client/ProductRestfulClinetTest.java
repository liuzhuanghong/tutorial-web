package com.steven.tutorial.web.service.client;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.steven.tutorial.web.domain.Product;

public class ProductRestfulClinetTest {

	private static String PRODUCT_RESTFUL_URL = "http://localhost:8088/tutorial-web/ws/productService";

	@Test
	public void testGetProductById() {
		System.out.println("测试获取指定对象");
		WebClient client = WebClient.create(PRODUCT_RESTFUL_URL);
		String msg = client.path("product/1").get(String.class);
		Gson gson = new Gson();
		Product product = gson.fromJson(msg, Product.class);
		System.out.println(product);

	}

	@Test
	public void testGetAllProduct() {
		System.out.println("测试获取所有对象");
		WebClient client = WebClient.create(PRODUCT_RESTFUL_URL);
		String msg = client.path("/").get(String.class);
		Gson gson = new Gson();
		List<Product> lstProducts = gson.fromJson(msg, new TypeToken<List<Product>>() {
		}.getType());
		for (Product product : lstProducts) {
			System.out.println(product);
		}

		// 使用JacksonJsonProvider
		System.out.println("使用JacksonJsonProvider获取数据");
		JacksonJsonProvider jsonProvider = new JacksonJsonProvider();
		List<Product> productList = ClientBuilder.newClient().register(jsonProvider).target(PRODUCT_RESTFUL_URL)
				.path("/").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Product>>() {
				});
		for (Object item : productList) {
			System.out.println(item);
		}
	}
	@Test
	public void testDeleteProduct() {
		System.out.println("测试删除对象");
		WebClient client = WebClient.create(PRODUCT_RESTFUL_URL);
		client.path("product/2").delete();
	}
	@Test
	public void testAddProduct() {
		System.out.println("测试添加对象");
//		Product product = new Product(3, "mac pro", 8800);
//		Gson gson = new Gson();
//		String strJson = gson.toJson(product);
//		System.out.println(strJson);
//		JacksonJsonProvider jsonProvider = new JacksonJsonProvider();
//		ClientBuilder.newClient().register(jsonProvider).target(PRODUCT_RESTFUL_URL)
//				.path("/product").request(MediaType.APPLICATION_JSON).post(entity)
		
	       //String url = "http://localhost:8000/CXFWebService/rest/";
		// WebClient client = WebClient.create(PRODUCT_RESTFUL_URL);
		// client.path("product").post(strJson);
	}

}
