package com.chinesedreamer.stocks.business.user.logic;

import com.chinesedreamer.stocks.domain.base.jpa.BaseLogic;
import com.chinesedreamer.stocks.domain.user.model.User;

public interface UserLogic extends BaseLogic<User, Long>{
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);
}
