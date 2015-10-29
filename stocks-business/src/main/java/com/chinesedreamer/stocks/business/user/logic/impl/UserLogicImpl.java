package com.chinesedreamer.stocks.business.user.logic.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.user.logic.UserLogic;
import com.chinesedreamer.stocks.domain.base.jpa.BaseLogicImpl;
import com.chinesedreamer.stocks.domain.user.model.User;
import com.chinesedreamer.stocks.domain.user.repository.UserRepository;

@Service
public class UserLogicImpl extends BaseLogicImpl<User, Long> implements UserLogic{
	
	@Resource
	private UserRepository repository;

	@Override
	public User findByUsername(String username) {
		return this.repository.findByUsername(username);
	}

}
