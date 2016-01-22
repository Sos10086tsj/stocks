package com.chinesedreamer.stocks.business.permission.logic;

import java.util.List;

import com.chinesedreamer.stocks.domain.base.jpa.BaseLogic;
import com.chinesedreamer.stocks.domain.user.model.UserRole;

public interface UserRoleLogic extends BaseLogic<UserRole, Long>{
	public List<UserRole> getUserRole(Long userId);
}
