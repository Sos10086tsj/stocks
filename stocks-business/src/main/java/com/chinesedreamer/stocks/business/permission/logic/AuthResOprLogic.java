package com.chinesedreamer.stocks.business.permission.logic;

import java.util.Collection;
import java.util.List;

import com.chinesedreamer.stocks.domain.base.jpa.BaseLogic;
import com.chinesedreamer.stocks.domain.rabc.model.AuthResOperation;

public interface AuthResOprLogic extends BaseLogic<AuthResOperation, Long>{
	public List<AuthResOperation> getByAuthCodes(Collection<String> authCodes);
}
