package dao;

import entity.User;

import java.util.List;

public interface UserDao {
	public User queryUserById(int id);
	public int add(User user);
	public int queryCounts();
	public int delete(String name);
	public int update(User user);
	public List<User> queryAll();
	public User queryByName(String name);
	
}
