package com.zyf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zyf.entity.Account;

public interface AccountDao extends JpaRepository<Account, Integer> {
	

}
