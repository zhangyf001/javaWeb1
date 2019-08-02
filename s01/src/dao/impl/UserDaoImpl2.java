package dao.impl;

import dao.UserDao;
import entity.User;

public class UserDaoImpl2 implements UserDao{

	@Override
	public void add(User u) {
		System.out.println("UserDaoImpl2");
	}

}
