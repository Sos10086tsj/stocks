package com.chinesedreamer.stocks.business.permission.logic;

import java.util.Collection;
import java.util.List;

import com.chinesedreamer.stocks.domain.base.jpa.BaseLogic;
import com.chinesedreamer.stocks.domain.rabc.model.Resource;

public interface ResourceLogic extends BaseLogic<Resource, Long>{
	public Resource getAvailableByCode(String code);
	
	public List<Resource> getAvaliableByCodesInOrder(Collection<String> codes);
}
