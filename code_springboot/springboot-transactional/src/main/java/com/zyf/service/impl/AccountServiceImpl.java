package com.zyf.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyf.dao.AccountDao;
import com.zyf.entity.Account;
import com.zyf.service.AccountService;
@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Resource
	private AccountDao accountDao;
	
	@Transactional
	public void transferAccounts(int fromUser, int toUser, float account) {
		Account fromAccount = accountDao.getOne(fromUser);//查出A的账户信息
		fromAccount.setBalance(fromAccount.getBalance()-account);//从A账户扣掉转账的金额
		accountDao.save(fromAccount);//保存A账户信息
		
		Account toAccount = accountDao.getOne(toUser);//查出B账户信息
		toAccount.setBalance(toAccount.getBalance()+account);//从B账户存入转账的金额
		
		accountDao.save(toAccount);//保存B账户信息
		
		
		
	}

}
