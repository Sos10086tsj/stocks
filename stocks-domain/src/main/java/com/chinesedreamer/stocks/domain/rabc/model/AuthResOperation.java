package com.chinesedreamer.stocks.domain.rabc.model;

import javax.persistence.Table;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table(name = "sys_auth_res_oper")
public class AuthResOperation extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3371906373908162766L;

	@Column(name = "auth_code")
	private String authCode;
	
	@Column(name = "res_code")
	private String resCode;
	
	@Column(name = "oper_code")
	private String operCode;

	public String getAuthCode() {
		return authCode;
	}

	public String getResCode() {
		return resCode;
	}

	public String getOperCode() {
		return operCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}
	
	
}
