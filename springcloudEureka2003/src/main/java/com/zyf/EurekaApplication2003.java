package com.zyf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * created by zhangyf on 2020-03-16 20:50
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication2003 {
  public static void main(String[] args) {
	SpringApplication.run(EurekaApplication2003.class, args);
  }
}
