package com.chinesedreamer.stocks.business.session.logic;

import com.chinesedreamer.stocks.business.session.exception.SessionOverdueException;
import com.chinesedreamer.stocks.domain.session.model.UserSession;

public interface UserSessionLogic{
	/**
	 * 保存用户session
	 */
	public void saveUserSessionCache(UserSession userSession);
	
	/**
	 * 删除缓存
	 * @param userSession
	 */
	public void clear(UserSession userSession);
	
	/*
	 * 检查session是否存在
	 */
	public void validateSession() throws SessionOverdueException;
	
	/**
	 * 获取当前用户
	 * @return
	 */
	public UserSession getCurrentUserSession();
	
	/**
	 * 根据用户名查找 UserSession
	 * @param user
	 * @return
	 */
	public UserSession findByUser(String user);
	
	/**
	 * 根据session id查找 UserSession
	 * @param sessionId
	 * @return
	 */
	public UserSession findBySessionId(String sessionId);
	
	/**
	 * 保存user session表
	 * @param userSession
	 * @return
	 */
	public UserSession save(UserSession userSession);
}
