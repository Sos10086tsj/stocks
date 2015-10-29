package com.chinesedreamer.stocks.business.session.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.session.exception.SessionOverdueException;
import com.chinesedreamer.stocks.business.session.logic.UserSessionLogic;
import com.chinesedreamer.stocks.business.session.service.UserSessionService;
import com.chinesedreamer.stocks.domain.session.model.UserSession;

@Service
public class UserSessionServiceImpl implements UserSessionService{
	
	@Resource
	private UserSessionLogic logic;

	@Override
	public void saveUserSessionCache(UserSession userSession) {
		this.logic.saveUserSessionCache(userSession);
	}

	@Override
	public void clear(UserSession userSession) {
		this.logic.clear(userSession);
	}

	@Override
	public void validateSession() throws SessionOverdueException {
		this.logic.validateSession();
	}

	@Override
	public UserSession getCurrentUserSession() {
		return this.logic.getCurrentUserSession();
	}

	@Override
	public UserSession findByUser(String user) {
		return this.logic.findByUser(user);
	}

	@Override
	public UserSession findBySessionId(String sessionId) {
		return this.logic.findBySessionId(sessionId);
	}

	@Override
	public UserSession save(UserSession userSession) {
		return this.logic.save(userSession);
	}

}
