package biz.impl;

import biz.UserBiz;
import dao.UserDao;
import entity.User;

public class UserBizImpl implements UserBiz{
	private UserDao userDao;
	private String bName;
	private int bNum;
	@Override
	public String toString() {
		return "UserBizImpl [bName=" + bName + ", bNum=" + bNum +", userDao=" + userDao + "]";
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}
	
	

	public void add(User u) {
		System.out.println("biz的bName属性："+bName);
		System.out.println("biz的bNum属性："+bNum);
		System.out.println("biz层添加了"+u.toString());
		userDao.add(u);
	}
	
	public UserBizImpl() {
		super();
	}

	public UserBizImpl(String bName, int bNum) {
		super();
		this.bName = bName;
		this.bNum = bNum;
	}

	public UserBizImpl(String bName, int bNum,UserDao userDao) {
		super();
		this.bName = bName;
		this.bNum = bNum;
		this.userDao = userDao;
	}

	
	
	


}
