package com.steven.tutorial.web.dao;

import com.steven.tutorial.web.domain.LoginUser;

/**
 * 登录用户操作Dao
 * 
 * @author liuzhuanghong
 *
 */
public interface LoginUserDao {
	
	LoginUser getUser(int id);

	int insertUser(LoginUser user);

	int updateUser(LoginUser user);

	int deleteUser(int id);

	int getUserNum(LoginUser user);
}
