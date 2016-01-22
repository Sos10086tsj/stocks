package com.chinesedreamer.stocks.domain.user.repository;

import java.util.List;

import com.chinesedreamer.stocks.domain.base.jpa.BaseRepository;
import com.chinesedreamer.stocks.domain.user.model.UserRole;

public interface UserRoleRepository extends BaseRepository<UserRole, Long>{
	public List<UserRole> findByUserId(Long userId);
}
