package dao.impl;

import org.springframework.stereotype.Repository;

import dao.UserDao;
import entity.User;
@Repository
public class UserDaoImpl implements UserDao {

	public void add(User u) {
		System.out.println("Dao层添加了"+u.toString());
	}

}
