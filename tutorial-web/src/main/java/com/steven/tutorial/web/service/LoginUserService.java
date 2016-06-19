/**
 * @author liuzhuanghong
 */
package com.steven.tutorial.web.service;

import com.steven.tutorial.web.domain.LoginUser;

/**
 * 登录用户WebService服务，采用自动注解的方式实现
 * 
 * @author liuzhuanghong
 *
 */
public interface LoginUserService {
	
	LoginUser getUser(int id);

	int insertUser(LoginUser user);

	int updateUser(LoginUser user);

	int deleteUser(int id);

	int getUserNum(LoginUser user);
}
