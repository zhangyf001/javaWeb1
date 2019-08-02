package test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.ClassDao;
import entity.MyClass;
import entity.Student;


/**
 * mybatis 多个班级对应一个老师的关系 以及 一个班级对应多个学生的关系
 * @author yfzhang 
 *
 */
public class Test {
	public static void main(String[] args) {
		InputStream is = Test.class.getClassLoader().getResourceAsStream("MyBatis-configuration.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		ClassDao classDao = session.getMapper(ClassDao.class);
		
		MyClass myClass =  classDao.queryClassById(1);
		System.out.println(myClass.toString());
		
		MyClass myClass2 = classDao.queryClassTeacherById(1);
		System.out.println(myClass2);
		
		MyClass myClass3 = classDao.queryClassStudentById(1);
		System.out.println(myClass3.toString());
		
		MyClass myClass4 = classDao.queryClassTeacherStudentById(1);
		System.out.println(myClass4.toString());
		
		
		
	}
}
