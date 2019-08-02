package dao.impl;

import dao.UserDao;
import entity.User;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImpl2 implements UserDao{
	
	public void add(User u) {
		System.out.println("UserDaoImpl2");
	}

}
