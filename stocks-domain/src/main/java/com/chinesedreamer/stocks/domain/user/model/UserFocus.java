package com.chinesedreamer.stocks.domain.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

@Entity
@Table(name = "user_focus")
public class UserFocus extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8159394369804128898L;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "stock_code")
	private String stockCode;

	public Long getUserId() {
		return userId;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	
	
}
