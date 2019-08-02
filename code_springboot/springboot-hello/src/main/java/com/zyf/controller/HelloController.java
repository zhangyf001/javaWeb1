package com.zyf.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyf.properties.MysqlProperties;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	@ResponseBody
	public Map<String,Object> aa(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "zansan");
		map.put("gender", "男");
		return map;
	}
	@Value("${helloWorld}")
	private String helloWorld;
	
	@Value("${mysql.jdbcName}")
	private String jdbcName;
	
	@Value("${mysql.dbUrl}")
	private String dbUrl;
	
	@Value("${mysql.userName}")
	private String userName;
	
	@Value("${mysql.password}")
	private String password;
	
	@RequestMapping("/hello2")
	@ResponseBody
	public Map<String, Object> aaf(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("helloWorld", helloWorld);
		map.put("jdbcName", jdbcName);
		map.put("dbUrl", dbUrl);
		map.put("userName",userName);
		map.put("password", password);
		return map;
	}
	@Resource
	private MysqlProperties mysqlProperties;
	
	@RequestMapping("/hello3")
	@ResponseBody
	public Map<String, Object> saf(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jdbcName", mysqlProperties.getJdbcName());
		map.put("dbUrl", mysqlProperties.getDbUrl());
		map.put("userName",mysqlProperties.getUserName());
		map.put("password", mysqlProperties.getPassword());
		return map;
	}
	
}
