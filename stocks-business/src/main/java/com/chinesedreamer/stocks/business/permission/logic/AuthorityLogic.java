package com.chinesedreamer.stocks.business.permission.logic;

import com.chinesedreamer.stocks.domain.base.jpa.BaseLogic;
import com.chinesedreamer.stocks.domain.rabc.model.Authority;

public interface AuthorityLogic extends BaseLogic<Authority, Long>{
	public Authority getByCode(String code);
	
	public Authority getByCodeAvailable(String code);
}
