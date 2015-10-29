package com.chinesedreamer.stocks.business.session.logic.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.filter.SessionFilter;
import com.chinesedreamer.stocks.business.session.exception.SessionOverdueException;
import com.chinesedreamer.stocks.business.session.logic.UserSessionLogic;
import com.chinesedreamer.stocks.business.session.service.impl.UserSessionServiceImpl;
import com.chinesedreamer.stocks.domain.base.cache.BaseCacheAspect;
import com.chinesedreamer.stocks.domain.session.model.UserSession;
import com.chinesedreamer.stocks.domain.session.repository.UserSessionRepository;

@Service
public class UserSessionLogicImpl extends BaseCacheAspect implements UserSessionLogic{
	public UserSessionLogicImpl() {
		setCacheName(userSessionCacheName);
	}
	
	private final Logger logger = LoggerFactory
			.getLogger(UserSessionServiceImpl.class);

	@Resource
	private UserSessionRepository repository;
	
	private final String userSessionCacheName = "sessionCache";
	private final String userSessionPrefix = "user-session-";

	@Override
	public void saveUserSessionCache(UserSession userSession) {
		this.logger.info("save user session cache:" + userSession);
		if (null == userSession) {
			return;
		}
		setCacheName(userSessionCacheName);
		this.put(userSessionPrefix + userSession.getSessionId(), userSession);
	}

	@Override
	public void clear(UserSession userSession) {
		this.evict(userSessionPrefix + userSession.getSessionId());
		userSession = this.repository.findBySessionId(userSession.getSessionId());
		this.repository.delete(userSession);
	}

	@Override
	public void validateSession() throws SessionOverdueException {
		HttpServletRequest request = SessionFilter.SessionContext.getContext();
		String sessionId = request.getSession().getId();
		UserSession userSession = this.get(userSessionPrefix + sessionId);
		if (null == userSession) {
			throw new SessionOverdueException("Session Overdue, please relogin.");
		}
	}

	@Override
	public UserSession getCurrentUserSession() {
		HttpServletRequest request = SessionFilter.SessionContext.getContext();
		String sessionId = request.getSession().getId();
		UserSession userSession = this.get(userSessionPrefix + sessionId);
		if (null == userSession) {
			throw new SessionOverdueException("Session Overdue, please relogin.");
		}
		return userSession;
	}

	@Override
	public UserSession findByUser(String user) {
		return this.repository.findByUser(user);
	}

	@Override
	public UserSession findBySessionId(String sessionId) {
		return this.repository.findBySessionId(sessionId);
	}

	@Override
	public UserSession save(UserSession userSession) {
		return this.repository.saveAndFlush(userSession);
	}
}
