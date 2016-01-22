package com.chinesedreamer.stocks.business.user.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.filter.SessionFilter;
import com.chinesedreamer.stocks.business.session.logic.UserSessionLogic;
import com.chinesedreamer.stocks.business.user.constant.UserException;
import com.chinesedreamer.stocks.business.user.exception.UserLoginException;
import com.chinesedreamer.stocks.business.user.exception.UserNotExistException;
import com.chinesedreamer.stocks.business.user.exception.UserPassIllegal;
import com.chinesedreamer.stocks.business.user.exception.UserPassNotMatchException;
import com.chinesedreamer.stocks.business.user.logic.UserLogic;
import com.chinesedreamer.stocks.business.user.service.UserService;
import com.chinesedreamer.stocks.common.util.EncryptionUtil;
import com.chinesedreamer.stocks.domain.session.constant.UserSessionClient;
import com.chinesedreamer.stocks.domain.session.model.UserSession;
import com.chinesedreamer.stocks.domain.user.model.User;

@Service
public class UserServiceImpl implements UserService{
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Resource
	private UserLogic logic;
	@Resource
	private UserSessionLogic userSessionLogic;

	@Override
	public void login(String username, String password, Integer source) throws UserLoginException{
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			throw new UserPassIllegal(UserException.USER_PASS_ILLEGAL + " " + UserException.USER_PASS_ILLEGAL.getMessage() + " user:" + username + " password:" + password);
		}
		User user = this.logic.findByUsername(username);
		if (null == user) {
			throw new UserNotExistException(UserException.USER_NOT_EXIST + " " + UserException.USER_NOT_EXIST.getMessage() + " user:" + username);
		}
		if (!user.getPassword().equals(EncryptionUtil.md5L32(password + user.getSalt()))) {
			throw new UserPassNotMatchException(UserException.USER_PASS_NOT_MATCH + " " + UserException.USER_PASS_NOT_MATCH.getMessage() + " user:" + username + " password:" + password);
		}
		logger.info("user:{} login at {}.", username, new Date());
		//保存session
		this.saveUserSession(user,source);
	}

	@Override
	public void register(String username, String password, String invitationCode) throws UserLoginException {
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(invitationCode)) {
			throw new UserPassIllegal(UserException.USER_PASS_ILLEGAL + " " + UserException.USER_PASS_ILLEGAL.getMessage() + " user:" + username + " password:" + password);
		}
		User user = this.logic.findByUsername(username);
		if (null != user) {
			throw new UserNotExistException(UserException.USER_EXIST + " " + UserException.USER_EXIST.getMessage() + " user:" + username);
		}
		user = new User();
		user.setUsername(username);
		String salt = EncryptionUtil.generateSalt(6);
		user.setSalt(salt);
		user.setPassword(EncryptionUtil.md5L32(user.getPassword() + salt));
		user = this.logic.save(user);
	}

	private void saveUserSession(User user, Integer source){
		UserSession us = this.userSessionLogic.findByUser(user.getUsername());
		if (us == null) {
			us = new UserSession();
		}
		us.setActiveDate(new Date());
		us.setClient(UserSessionClient.get(source));
		us.setSessionId(SessionFilter.SessionContext.getContext().getSession().getId());
		us.setUser(user.getId().toString());
		
		us = this.userSessionLogic.save(us);
		this.userSessionLogic.saveUserSessionCache(us);
	}

	@Override
	public User getById(Long id) {
		return this.logic.findOne(id);
	}
}
