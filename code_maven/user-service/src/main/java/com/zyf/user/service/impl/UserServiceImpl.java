package com.zyf.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyf.user.dao.UserDao;
import com.zyf.user.entity.User;
import com.zyf.user.service.UserService;

/**
 * 用户Service实现类
 * @author Administrator
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public User login(User user) {
		return userDao.login(user);
	}

}
