package com.steven.tutorial.web.service.client;

import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import com.steven.tutorial.web.domain.User;
import com.steven.tutorial.web.service.UserService;

public class UserServiceClientTest {

	@Test
	public void test() {

		System.out.println("Testing the client");
		// 定义JaxWs的代理工厂
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setServiceClass(UserService.class);
		factoryBean.setAddress("http://localhost:8088/tutorial-web/ws/userService");
		UserService service = (UserService) factoryBean.create();
		List<User> users = service.getAllUsers();
		for(User item : users){
			System.out.println("User ID: " + item.getUserId() + ", User Name: " + item.getUserName());
		}

	}

}
