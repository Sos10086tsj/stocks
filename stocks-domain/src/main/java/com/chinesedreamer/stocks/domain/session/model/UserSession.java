package com.chinesedreamer.stocks.domain.session.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;
import com.chinesedreamer.stocks.domain.session.constant.UserSessionClient;

/**
 * 系统session类
 * @author Paris
 *
 */
@Entity
@Table(name = "session")
public class UserSession extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -222676411829704184L;
	
	/**
	 * 用户外键id
	 */
	@Column(name = "user")
	private String user;
	
	/**
	 * session id
	 */
	@Column(name = "session_id")
	private String sessionId;
	
	/**
	 * session来源
	 */
	@Column(name = "client")
	@Enumerated(EnumType.ORDINAL)
	private UserSessionClient client = UserSessionClient.DEFAULT;
	
	/**
	 * 活跃时间
	 */
	@Column(name = "active_date")
	private Date activeDate = new Date();

	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSessionId() {
		return sessionId;
	}

	public UserSessionClient getClient() {
		return client;
	}

	public Date getActiveDate() {
		return activeDate;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public void setClient(UserSessionClient client) {
		this.client = client;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}
	
	
}
