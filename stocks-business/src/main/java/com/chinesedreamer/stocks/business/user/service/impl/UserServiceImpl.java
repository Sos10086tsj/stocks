package com.chinesedreamer.stocks.business.user.service.impl;

import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.user.service.UserService;
import com.chinesedreamer.stocks.domain.base.jpa.BaseServiceImpl;
import com.chinesedreamer.stocks.domain.user.model.User;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService{

}
