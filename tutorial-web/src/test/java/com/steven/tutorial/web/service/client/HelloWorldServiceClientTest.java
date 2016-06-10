package com.steven.tutorial.web.service.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import com.steven.tutorial.web.service.HelloWorldService;

import junit.framework.Assert;

public class HelloWorldServiceClientTest {

	@Test
	public void test() {

		System.out.println("Testing the client");
		// 定义JaxWs的代理工厂
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setServiceClass(HelloWorldService.class);
		factoryBean.setAddress("http://localhost:8088/tutorial-web/ws/helloWorld");
		HelloWorldService helloService = (HelloWorldService) factoryBean.create();
		String result = helloService.sayHello();
		Assert.assertEquals(result, "Hello world!");
		System.out.println("The result is: " + result);

	}

}
