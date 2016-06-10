/**
 * @author liuzhuanghong
 */
package com.steven.tutorial.web.service;

import java.util.List;

import javax.jws.WebService;

import com.steven.tutorial.web.domain.User;

/**
 * 用户相关操作
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
