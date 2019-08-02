package test;

import dao.UserDao;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * mybatis框架搭建，实现基本操作
6 * @author yfzhang
 * 
 */
public class Test {
	public static void main(String[] args) {
		InputStream is = Test.class.getClassLoader().getResourceAsStream("resource/MyBatis-configuration.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		/*try{
			User user = (User) session.selectOne("resource.mappers.UserDao.queryUserById",1);
			System.out.println(user.toString());
		}finally {
			session.close();
		}*/


		UserDao userDao = session.getMapper(UserDao.class);
		User user = userDao.queryUserById(1);
		if (user != null) {
			System.out.println(user.toString());
		}else{
			System.out.println("没有此条记录！");
		}
		
		
	/*	User user = new User("大四","wweeww","男");
		userDao.add(user);
		session.commit();//添加数据得提交，不然插入不到数据库中
		session.close();*/
		
		/*int c = userDao.delete("aa");
		System.out.println("共删除"+c+"条记录");
		session.commit();//删除数据也得提交，不然删除不了
		session.close();*/


	}
}
