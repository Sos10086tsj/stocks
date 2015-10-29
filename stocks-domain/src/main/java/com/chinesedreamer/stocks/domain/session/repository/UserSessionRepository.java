package com.chinesedreamer.stocks.domain.session.repository;

import com.chinesedreamer.stocks.domain.base.jpa.BaseRepository;
import com.chinesedreamer.stocks.domain.session.model.UserSession;

public interface UserSessionRepository extends BaseRepository<UserSession, Long>{
	public UserSession findBySessionId(String sessionId);
	
	public UserSession findByUser(String user);
}
