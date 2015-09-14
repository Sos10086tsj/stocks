package com.chinesedreamer.stocks.domain.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

@Entity
@Table(name = "user")
public class User extends BaseEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3067957715772614535L;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String salt;
	
	@Column
	private String name;
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getSalt() {
		return salt;
	}
	public String getName() {
		return name;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
