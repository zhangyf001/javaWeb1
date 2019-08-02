package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import action.UserAction;
//aop
public class Test {
	public static void main(String[] args) {
		//读取配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		//实例化bean
		UserAction userAction =   (UserAction) ac.getBean("userAction");
		userAction.add();
		ac.close();
	}
}
