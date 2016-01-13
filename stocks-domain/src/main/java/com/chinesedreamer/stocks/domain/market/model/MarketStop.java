package com.chinesedreamer.stocks.domain.market.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

@Entity
@Table(name = "market_stop")
public class MarketStop extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1066813637856829302L;

	@Column
	private Integer date;					//日期

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}
	
	
}
