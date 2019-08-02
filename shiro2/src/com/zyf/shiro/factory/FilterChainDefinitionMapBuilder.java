package com.zyf.shiro.factory;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

	public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		
		map.put("/login.jsp", "anon");
		map.put("/shiro/login", "anon");
		map.put("/shiro/logout", "logout");
		map.put("/user.jsp", "authc,roles[user]");//带authc的 登录时候设置了记住我 token.setRememberMe(true); 重启浏览器 访问需要认证
		map.put("/admin.jsp", "authc,roles[admin]");
		map.put("/list.jsp", "user");//不带 authc 的 登录时候设置了记住我 token.setRememberMe(true); 重启浏览器 在cookie时长内 不需要认证
		
		map.put("/**", "authc");
		
		return map;
	}
	
}
