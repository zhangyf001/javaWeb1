package biz.impl;

import biz.UserBiz;
import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserBizImpl implements UserBiz{
	/**
	 * 这里注入UserDao，但是由于UserDao有多个实现类，故注入进来的时候spring不知道要注入哪个
	 * 会报创建userBizImpl bean 时报的错误
	 *
	 * 当下面这个UserDao有多个实现类的时候，spring就不知道该注入哪个实现类了就会报错
	 * 那么需要这么解决,表示优先注入这个实现类
	 * @Primary
	 * public class UserDaoImpl2 implements UserDao{
	 *
	 * }
	 * 或者：
	 * @Autowired
	 * @Qualifier("userDaoImpl2")
	 * private UserDao  userDao;
	 */
	@Autowired
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	/**在setter上注入
	 * @Autowired
	 * public void setUserDao(UserDao userDao) {
	 * 	this.userDao = userDao;
	 * }
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void add(User u) {
		System.out.println("biz层添加了"+u.toString());
		/*userDao.add(u);*/
	}

}
