package com.chinesedreamer.stocks.business.user.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.user.constant.UserException;
import com.chinesedreamer.stocks.business.user.exception.UserLoginException;
import com.chinesedreamer.stocks.business.user.exception.UserNotExistException;
import com.chinesedreamer.stocks.business.user.exception.UserPassIllegal;
import com.chinesedreamer.stocks.business.user.exception.UserPassNotMatchException;
import com.chinesedreamer.stocks.business.user.service.UserService;
import com.chinesedreamer.stocks.common.util.EncryptionUtil;
import com.chinesedreamer.stocks.domain.base.jpa.BaseServiceImpl;
import com.chinesedreamer.stocks.domain.user.model.User;
import com.chinesedreamer.stocks.domain.user.repository.UserRepository;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService{
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Resource
	private UserRepository userRepository;

	@Override
	public void login(String username, String password, Integer source) throws UserLoginException{
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			throw new UserPassIllegal(UserException.USER_PASS_ILLEGAL + " " + UserException.USER_PASS_ILLEGAL.getMessage() + " user:" + username + " password:" + password);
		}
		User user = this.userRepository.findByUsername(username);
		if (null == user) {
			throw new UserNotExistException(UserException.USER_NOT_EXIST + " " + UserException.USER_NOT_EXIST.getMessage() + " user:" + username);
		}
		if (!user.getPassword().equals(EncryptionUtil.md5L32(user.getPassword() + user.getSalt()))) {
			throw new UserPassNotMatchException(UserException.USER_PASS_NOT_MATCH + " " + UserException.USER_PASS_NOT_MATCH.getMessage() + " user:" + username + " password:" + password);
		}
		logger.info("user:{} login at {}.", username, new Date());
		//TODO 保存session
	}

	@Override
	public void register(String username, String password) throws UserLoginException {
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			throw new UserPassIllegal(UserException.USER_PASS_ILLEGAL + " " + UserException.USER_PASS_ILLEGAL.getMessage() + " user:" + username + " password:" + password);
		}
		User user = this.userRepository.findByUsername(username);
		if (null == user) {
			throw new UserNotExistException(UserException.USER_NOT_EXIST + " " + UserException.USER_NOT_EXIST.getMessage() + " user:" + username);
		}
		user = new User();
		user.setUsername(username);
		String salt = EncryptionUtil.generateSalt(6);
		user.setSalt(salt);
		user.setPassword(EncryptionUtil.md5L32(user.getPassword() + salt));
		this.save(user);
	}

}
