package com.chinesedreamer.stocks.business.permission.logic.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.permission.logic.AuthorityLogic;
import com.chinesedreamer.stocks.domain.base.jpa.BaseLogicImpl;
import com.chinesedreamer.stocks.domain.rabc.model.Authority;
import com.chinesedreamer.stocks.domain.rabc.repository.AuthorityRepository;

@Service
public class AuthorityLogicImpl extends BaseLogicImpl<Authority, Long> implements AuthorityLogic{
	
	@Resource
	private AuthorityRepository repository;
	@Override
	public Authority getByCode(String code) {
		return this.repository.findByCode(code);
	}
	@Override
	public Authority getByCodeAvailable(String code) {
		return this.repository.findByCodeAndDeletedFalse(code);
	}

}
