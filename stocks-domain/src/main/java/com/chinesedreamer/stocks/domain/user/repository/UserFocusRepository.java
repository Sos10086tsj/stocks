package com.chinesedreamer.stocks.domain.user.repository;

import java.util.List;

import com.chinesedreamer.stocks.domain.base.jpa.BaseRepository;
import com.chinesedreamer.stocks.domain.user.model.UserFocus;

public interface UserFocusRepository extends BaseRepository<UserFocus, Long>{
	public List<UserFocus> findByUserId(Long userId);
}
