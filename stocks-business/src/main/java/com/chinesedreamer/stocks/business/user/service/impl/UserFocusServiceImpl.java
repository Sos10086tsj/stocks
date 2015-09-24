package com.chinesedreamer.stocks.business.user.service.impl;

import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.user.service.UserFocusService;
import com.chinesedreamer.stocks.domain.base.jpa.BaseServiceImpl;
import com.chinesedreamer.stocks.domain.user.model.UserFocus;

@Service
public class UserFocusServiceImpl extends BaseServiceImpl<UserFocus, Long> implements UserFocusService{

}
