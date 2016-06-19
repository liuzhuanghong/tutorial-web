package com.steven.tutorial.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steven.tutorial.web.dao.LoginUserDao;
import com.steven.tutorial.web.domain.LoginUser;
import com.steven.tutorial.web.service.LoginUserService;

@Service("loginUserServiceImpl")
public class LoginUserServiceImpl implements LoginUserService {

	@Autowired
	private LoginUserDao loginUserDao;

	@Override
	public LoginUser getUser(int id) {
		return loginUserDao.getUser(id);
	}

	@Override
	public int insertUser(LoginUser user) {
		return loginUserDao.insertUser(user);
	}

	@Override
	public int updateUser(LoginUser user) {
		return loginUserDao.updateUser(user);
	}

	@Override
	public int deleteUser(int id) {
		return loginUserDao.deleteUser(id);
	}

	@Override
	public int getUserNum(LoginUser user) {
		return loginUserDao.getUserNum(user);
	}

}
