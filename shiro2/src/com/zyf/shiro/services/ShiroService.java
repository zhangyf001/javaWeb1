package com.zyf.shiro.services;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;

import java.util.Date;

public class ShiroService {
	//表示这个方法 需要当前用户拥有admin这个角色才能进来
	@RequiresRoles({"admin"})
	public void testMethod(){
		System.out.println("testMethod, time: " + new Date());
		
		Session session = SecurityUtils.getSubject().getSession();
		Object val = session.getAttribute("key");
		
		System.out.println("Service SessionVal: " + val);
	}
	
}
 