package com.chinesedreamer.stocks.business.permission.logic.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.permission.logic.ResourceLogic;
import com.chinesedreamer.stocks.domain.base.jpa.BaseLogicImpl;
import com.chinesedreamer.stocks.domain.rabc.model.Resource;
import com.chinesedreamer.stocks.domain.rabc.repository.ResourceRepository;

@Service
public class ResourceLogicImpl extends BaseLogicImpl<Resource, Long> implements ResourceLogic{
	
	@javax.annotation.Resource
	private ResourceRepository repository;
	@Override
	public Resource getAvailableByCode(String code) {
		return this.repository.findByCodeAndDeletedFalse(code);
	}
	@Override
	public List<Resource> getAvaliableByCodesInOrder(Collection<String> codes) {
		return this.repository.findByCodeInAndDeletedFalse(codes);
	}

}
