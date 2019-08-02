package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.User;
import biz.UserBiz;
//控制反转
public class Test {
	public static void main(String[] args) {
		//读取配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		//实例化bean
		UserBiz userBiz =  (UserBiz) ac.getBean("userBizImpl");//userBizImpl为配置文件中bean节点的id
		System.out.println(userBiz.toString());
		User u = new User(2,"aa");
		userBiz.add(u);
		
		
		UserBiz userBiz2 =  (UserBiz) ac.getBean("userBizImpl2");
		System.out.println("2:"+userBiz2.toString());
		
		UserBiz userBiz3 =  (UserBiz) ac.getBean("userBizImpl3");
		System.out.println("3:"+userBiz3.toString());
		
		UserBiz userBiz4 =  (UserBiz) ac.getBean("userBizImpl4");
		System.out.println("4:"+userBiz4.toString());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
