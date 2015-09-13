package com.chinesedreamer.stocks.domain.line.model;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

import lombok.Setter;


import lombok.Getter;

/** 
 * Description: k线
 * @author Paris Tao
 * @version 1.0beta
 * @date 2015年9月12日 下午7:27:01 
 * Copyright:   Copyright (c)2015
 */
public @Getter @Setter class KLine extends BaseEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6286941119445308634L;

	private Long stockIndexId;	//股票指数ID	@link com.chinesedreamer.stocks.domain.stock.model.StockIndex.id
	
	//url
	private String minuteUrl;	//分时线查询
	private String dayUrl;		//日K线查询
	private String weekUrl;		//周K线查询
	private String monthUrl;	//月K线查询
}
