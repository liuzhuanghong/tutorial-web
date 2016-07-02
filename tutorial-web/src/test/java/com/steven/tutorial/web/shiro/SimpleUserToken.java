package com.steven.tutorial.web.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class SimpleUserToken {

	@Test
	public void test() {
		// 初始化SecurityManager
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		// 获取当前用户
		Subject user = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("bjangles", "dance");
        try {
        	user.login(token);
		} catch (Exception e) {
			System.out.println("随便输入一个用户名，登录失败了");
		}
        
        token = new UsernamePasswordToken("liu", "123456");
        try {
        	user.login(token);
        	System.out.println("登录成功，登录用户：liu");
		} catch (Exception e) {
			System.out.println("登录失败");
		}
        
        user.logout();
		

	}

}
