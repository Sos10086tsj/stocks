package com.chinesedreamer.stocks.domain.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

@Entity
@Table(name = "user_role")
public class UserRole extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4565795083882730798L;

	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "role_id")
	private Long roleId;

	public Long getUserId() {
		return userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	
}
