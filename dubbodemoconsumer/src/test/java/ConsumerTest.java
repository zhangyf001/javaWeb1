import com.zyf.shiro.service.ProviderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-demo-consumer.xml"});
        context.start();
        ProviderService providerService = (ProviderService) context.getBean("demoProviderService");
        String result = providerService.sayHello("你好");
        System.out.println("远程调用的结果："+result);
        try {
            System.in.read();
        } catch (IOException e) {

            e.printStackTrace();
        }
        context.close();
    }
}
