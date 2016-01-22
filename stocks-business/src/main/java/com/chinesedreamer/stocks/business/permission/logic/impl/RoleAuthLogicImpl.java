package com.chinesedreamer.stocks.business.permission.logic.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.permission.logic.RoleAuthLogic;
import com.chinesedreamer.stocks.domain.base.jpa.BaseLogicImpl;
import com.chinesedreamer.stocks.domain.rabc.model.RoleAuth;
import com.chinesedreamer.stocks.domain.rabc.repository.RoleAuthRepository;

@Service
public class RoleAuthLogicImpl extends BaseLogicImpl<RoleAuth, Long> implements RoleAuthLogic{

	@Resource
	private RoleAuthRepository repository;
	
	@Override
	public List<RoleAuth> getRoleAuths(Collection<String> roleCodes) {
		return this.repository.findByRoleCodeIn(roleCodes);
	}

}
