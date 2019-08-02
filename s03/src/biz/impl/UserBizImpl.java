package biz.impl;

import biz.UserBiz;
import dao.UserDao;
import entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserBizImpl implements UserBiz{
	@Resource
	private UserDao  userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void add(User u) {
		System.out.println("biz层添加了"+u.toString());
		//System.out.println(1/0);
		userDao.add(u);
	}

}
