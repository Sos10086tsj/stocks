package com.chinesedreamer.stocks.business.permission.logic.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.permission.logic.RoleLogic;
import com.chinesedreamer.stocks.domain.base.jpa.BaseLogicImpl;
import com.chinesedreamer.stocks.domain.rabc.model.Role;
import com.chinesedreamer.stocks.domain.rabc.repository.RoleRepository;

@Service
public class RoleLogicImpl extends BaseLogicImpl<Role, Long> implements RoleLogic{
	
	@Resource
	private RoleRepository repository;

	@Override
	public Role getAvailableRole(Long roleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
