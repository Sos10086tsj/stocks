package com.chinesedreamer.stocks.domain.session.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;
import com.chinesedreamer.stocks.domain.session.constant.UserSessionClient;
import com.chinesedreamer.stocks.domain.user.model.User;

/**
 * 系统session类
 * @author Paris
 *
 */
public class UserSession extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -222676411829704184L;
	
	/**
	 * 用户外键id
	 */
	@Column(name = "user_id")
	private Long userId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;
	
	/**
	 * session id
	 */
	@Column(name = "session_id")
	private String sessionId;
	
	@Column(name = "client")
	@Enumerated(EnumType.ORDINAL)
	private UserSessionClient client;
}
