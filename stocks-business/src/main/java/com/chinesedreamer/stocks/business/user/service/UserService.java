package com.chinesedreamer.stocks.business.user.service;

import com.chinesedreamer.stocks.business.user.exception.UserLoginException;

public interface UserService{
	/**
	 * 用户登陆
	 * @param username	用户名
	 * @param password	密码
	 * @param source	来源
	 * @throws UserLoginException
	 * @return
	 */
	public void login(String username, String password, Integer source)  throws UserLoginException;
	
	/**
	 * 用户注册
	 * @param username
	 * @param password
	 * @param invitationCode
	 * @throws UserLoginException
	 */
	public void register(String username, String password, String invitationCode) throws UserLoginException;
}
