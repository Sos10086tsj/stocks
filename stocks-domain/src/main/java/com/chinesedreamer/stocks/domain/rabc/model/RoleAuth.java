package com.chinesedreamer.stocks.domain.rabc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

@Entity
@Table(name = "sys_role_auth")
public class RoleAuth extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1116628856760932814L;

	@Column(name = "role_code")
	private String roleCode;
	
	@Column(name = "auth_code")
	private String authCode;

	public String getRoleCode() {
		return roleCode;
	}

	public String getAuthCode() {
		return authCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	
}
