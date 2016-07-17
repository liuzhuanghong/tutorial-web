package com.steven.tutorial.web.service.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.binding.soap.saaj.SAAJOutInterceptor;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.junit.Test;

import com.steven.tutorial.web.security.ClientPasswordCallback;
import com.steven.tutorial.web.service.HelloWorldService;

import junit.framework.Assert;

public class HelloWorldServiceClientTest {

	@Test
	public void test() {

		System.out.println("Testing the client");
		
		// 以下和服务端配置类似，不对，应该说服务端和这里的安全验证配置一致  
        Map<String, Object> outProps = new HashMap<String, Object>();  
        outProps.put(WSHandlerConstants.ACTION,  
                WSHandlerConstants.USERNAME_TOKEN);  
        outProps.put(WSHandlerConstants.USER, "client");  
        outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);  
        // 指定在调用远程ws之前触发的回调函数WsClinetAuthHandler，其实类似于一个拦截器  
        outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS,  
        		ClientPasswordCallback.class.getName());  
        List list = new ArrayList();  
        // 添加cxf安全验证拦截器，必须  
        list.add(new SAAJOutInterceptor());  
        list.add(new WSS4JOutInterceptor(outProps));  
		
		// 定义JaxWs的代理工厂
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setServiceClass(HelloWorldService.class);
		factoryBean.setAddress("http://localhost:8088/tutorial-web/ws/helloWorld");
		//注入拦截器，用于加密安全验证信息  
		factoryBean.getOutInterceptors().addAll(list);  
		HelloWorldService helloService = (HelloWorldService) factoryBean.create();
		String result = helloService.sayHello();
		Assert.assertEquals(result, "Hello world!");
		System.out.println("The result is: " + result);
	}
	
	//@Test
	public void testSimpleClient(){
		JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
		Client client = factory.createClient("http://localhost:8088/tutorial-web/ws/helloWorld?wsdl");
		try {
			Object[] results = client.invoke("sayHello", "liu");
			System.out.println("The result is: " + results[0]);
		} catch (Exception e) {
		}
	}

}
