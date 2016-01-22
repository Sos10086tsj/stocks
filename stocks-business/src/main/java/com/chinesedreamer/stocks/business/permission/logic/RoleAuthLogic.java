package com.chinesedreamer.stocks.business.permission.logic;

import java.util.Collection;
import java.util.List;

import com.chinesedreamer.stocks.domain.base.jpa.BaseLogic;
import com.chinesedreamer.stocks.domain.rabc.model.RoleAuth;

public interface RoleAuthLogic extends BaseLogic<RoleAuth, Long>{
	public List<RoleAuth> getRoleAuths(Collection<String> roleCodes);
}
