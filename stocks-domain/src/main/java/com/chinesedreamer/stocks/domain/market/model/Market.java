package com.chinesedreamer.stocks.domain.market.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

/** 
 * Description: 股票市场，比如上海、深证
 * @author Paris Tao
 * @version 1.0beta
 * @date 2015年9月12日 下午1:13:43 
 * Copyright:   Copyright (c)2015
 */
@Entity
@Table(name = "market")
public class Market extends BaseEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5769445366199222852L;
	@Column
	private String code;	//市场		sz
	@Column
	private String name;	//市场名		上证
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
