package util;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanUtil {
	//读取配置文件
	private static AbstractApplicationContext ac;
	static {
		ac = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	}
	//获得bean 实例化bean
	public static <T>T getBean(String beanName,Class<T> c){
		T t = ac.getBean(beanName,c);
		return t;
	}
}
