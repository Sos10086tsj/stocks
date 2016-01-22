package com.chinesedreamer.stocks.domain.rabc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

@Entity
@Table(name = "sys_authority")
public class Authority extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4424354645828626468L;

	@Column
	private String code;//唯一
	
	@Column
	private String name;
	
	@Column
	private String description;//描述
	
	@Column(name = "deleted", columnDefinition="TINYINT(1)")
	private Boolean deleted;//是否可用
	
	@Column(name = "show", columnDefinition="TINYINT(1)")
	private Boolean show;//是否在权限管理显示

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public Boolean getShow() {
		return show;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}
	
	
}
