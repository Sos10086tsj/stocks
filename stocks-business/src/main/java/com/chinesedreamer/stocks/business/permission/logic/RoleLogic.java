package com.chinesedreamer.stocks.business.permission.logic;

import com.chinesedreamer.stocks.domain.base.jpa.BaseLogic;
import com.chinesedreamer.stocks.domain.rabc.model.Role;

public interface RoleLogic extends BaseLogic<Role, Long>{
	public Role getAvailableRole(Long roleId);
}
