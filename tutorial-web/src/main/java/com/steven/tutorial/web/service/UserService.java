/**
 * @author liuzhuanghong
 */
package com.steven.tutorial.web.service;

import java.util.List;

import javax.jws.WebService;

import com.steven.tutorial.web.domain.User;

/**
 * 用户相关操作，仅用于WebService启动的测试
 * @author liuzhuanghong
 *
 */
@WebService
public interface UserService {
	/**
	 * 获取所有用户
	 *
	 */
	List<User> getAllUsers();

}
