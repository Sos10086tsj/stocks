package com.chinesedreamer.stocks.business.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.user.logic.UserFocusLogic;
import com.chinesedreamer.stocks.business.user.service.UserFocusService;
import com.chinesedreamer.stocks.domain.user.model.UserFocus;

@Service
public class UserFocusServiceImpl implements UserFocusService{
	
	@Resource
	private UserFocusLogic logic;

	@Override
	public List<UserFocus> findAll() {
		return this.logic.findAll();
	}

}
