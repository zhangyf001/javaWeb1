import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ProviderTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-demo-provider.xml"});
		context.start();
		System.out.println("服务提供者向zookeeper注册中心注册服务成功（端口：20880）");
		try {
			System.in.read();// press any key to exit
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		context.close();
	}
}
