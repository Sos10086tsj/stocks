package com.chinesedreamer.stocks.domain.sysconfig.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

@Entity
@Table(name = "sys_config")
public class SysConfig extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5286848883274063356L;

	@Column
	private String property;
	
	@Column(name = "property_value")
	private String propertyValue;

	public String getProperty() {
		return property;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	
	
}
