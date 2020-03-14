package com.zyf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

//注：消费者项目不需要注入数据源，所以这里的exclude表示排除数据源注入，不排除会报错
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class StudentConsumerApplication_80 {

	public static void main(String[] args) {
		SpringApplication.run(StudentConsumerApplication_80.class, args);
	}
}
