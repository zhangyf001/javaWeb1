package dao.impl;

import dao.UserDao;
import entity.User;

public class UserDaoImpl implements UserDao {

	public void add(User u) {
		System.out.println("Dao层添加了"+u.toString());
	}

}
