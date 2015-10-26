package com.chinesedreamer.stocks.domain.user.repository;

import com.chinesedreamer.stocks.domain.base.jpa.BaseRepository;
import com.chinesedreamer.stocks.domain.user.model.User;

public interface UserRepository extends BaseRepository<User, Long>{
	/**
	 * 查找username匹配的用户
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);
}
