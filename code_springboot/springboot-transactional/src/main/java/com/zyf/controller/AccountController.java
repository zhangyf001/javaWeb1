package com.zyf.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyf.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Resource
	private AccountService accountService;
	
	@RequestMapping("/transfer")
	public String transferAccounts(){
		try{//从id为1 的账户转199.99到账户id为2的账户
			accountService.transferAccounts(1, 2, 199.99f);	
			return "success";
		}catch(Exception e){
			return"fail";
		}
		
	}
	
}
