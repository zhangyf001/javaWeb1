package com.zyf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * created by zhangyf on 2020-03-14 15:45
 */
@EnableEurekaClient
@SpringBootApplication
public class StudentProviderApplication_1009 {

  public static void main(String[] args) {
	SpringApplication.run(StudentProviderApplication_1009.class, args);
  }
}
