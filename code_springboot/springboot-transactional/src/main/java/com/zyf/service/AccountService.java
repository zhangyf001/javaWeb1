package com.zyf.service;

public interface AccountService {
	/**
	 * 转账接口
	 * @param fromUser
	 * @param toUser
	 * @param account 转账金额
	 */
	public void  transferAccounts(int fromUser,int toUser,float account);
}
