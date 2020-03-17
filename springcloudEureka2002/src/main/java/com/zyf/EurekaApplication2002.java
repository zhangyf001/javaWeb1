package com.zyf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication2002 {
  public static void main(String[] args) {
	SpringApplication.run(EurekaApplication2002.class, args);
  }
}
