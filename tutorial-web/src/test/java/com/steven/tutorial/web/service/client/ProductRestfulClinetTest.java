package com.steven.tutorial.web.service.client;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

import com.google.gson.Gson;
import com.steven.tutorial.web.domain.Product;

public class ProductRestfulClinetTest {

	private static String PRODUCT_RESTFUL_URL = "http://localhost:8088/tutorial-web/ws/productService";

	@Test
	public void test() {

		WebClient client = WebClient.create(PRODUCT_RESTFUL_URL);
		String msg = client.path("product/1").get(String.class);
		Gson gson = new Gson();
		Product product = gson.fromJson(msg, Product.class);
		System.out.println(product);

	}

}
