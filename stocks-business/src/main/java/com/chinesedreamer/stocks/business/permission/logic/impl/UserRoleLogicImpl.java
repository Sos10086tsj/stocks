package com.chinesedreamer.stocks.business.permission.logic.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.permission.logic.UserRoleLogic;
import com.chinesedreamer.stocks.domain.base.jpa.BaseLogicImpl;
import com.chinesedreamer.stocks.domain.user.model.UserRole;
import com.chinesedreamer.stocks.domain.user.repository.UserRoleRepository;

@Service
public class UserRoleLogicImpl extends BaseLogicImpl<UserRole, Long> implements UserRoleLogic{
	
	@Resource
	private UserRoleRepository reponsitory;

	@Override
	public List<UserRole> getUserRole(Long userId) {
		return this.reponsitory.findByUserId(userId);
	}

}
