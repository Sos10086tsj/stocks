package com.chinesedreamer.stocks.domain.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

/** 
 * Description: 股票模型
 * @author Paris Tao
 * @version 1.0beta
 * @date 2015年9月12日 上午11:14:18 
 * Copyright:   Copyright (c)2015
 */
@Entity
@Table(name = "stock")
public class Stock extends BaseEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5873817062806320957L;

	@Column
	private String code;		//股票编码		000002
	@Column
	private String name;		//股票名称		万科A
	@Column(name = "market_code")
	private String marketCode;	//市场		sz		@link com.chinesedreamer.stocks.domain.market.model.Market.code
	@Column
	private String pinyin;		//股票拼音简写	WKA
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getMarketCode() {
		return marketCode;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	
	
}
