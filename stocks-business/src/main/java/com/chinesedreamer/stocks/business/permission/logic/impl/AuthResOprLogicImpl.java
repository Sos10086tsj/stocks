package com.chinesedreamer.stocks.business.permission.logic.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.permission.logic.AuthResOprLogic;
import com.chinesedreamer.stocks.domain.base.jpa.BaseLogicImpl;
import com.chinesedreamer.stocks.domain.rabc.model.AuthResOperation;
import com.chinesedreamer.stocks.domain.rabc.repository.AuthResOperationRepository;

@Service
public class AuthResOprLogicImpl extends BaseLogicImpl<AuthResOperation, Long> implements AuthResOprLogic{
	@Resource
	private AuthResOperationRepository respository;
	@Override
	public List<AuthResOperation> getByAuthCodes(Collection<String> authCodes) {
		return this.respository.findByAuthCodeIn(authCodes);
	}

}
