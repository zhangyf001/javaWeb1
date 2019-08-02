package com.zyf.aspect;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zyf.entity.Student;

@Aspect
@Component
public class RequestAspect {

	private Logger logger=Logger.getLogger(RequestAspect.class);
	
	@Pointcut("execution(public * com.zyf.controller.*.*(..))")
	public void log(){
	}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint){
		logger.info("方法执行前...");
		ServletRequestAttributes sra=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request=sra.getRequest();
		logger.info("url:"+request.getRequestURI());//url
		logger.info("ip:"+request.getRemoteHost());//ip
		logger.info("method:"+request.getMethod());//post还是get
		//调用的类以及方法
		logger.info("class_method:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		logger.info("args:"+joinPoint.getArgs());//参数
		Student student=(Student) joinPoint.getArgs()[0];
		System.out.println(student);
	}
	@After("log()")
	public void doAfter(JoinPoint joinPoint){
		logger.info("方法执行后...");
	}
	@AfterReturning(returning="result",pointcut="log()")
	public void doAfterReturning(Object result){
		logger.info("方法返回值："+result);
	}
}
