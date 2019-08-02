package test;

import entity.PojoConfig;
import entity.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//控制反转 注解方式
public class Test {
	public static void main(String[] args) {
		/*//读取配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		//实例化bean
		UserAction userAction =   (UserAction) ac.getBean("userAction");
		userAction.add();
		ac.close();*/
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(PojoConfig.class);
		Role role = (Role) ac.getBean("role");//也可以这么获取Role role = ac.getBean(Role.class);
		System.out.println(role.getId());
	}
}
