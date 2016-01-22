package com.chinesedreamer.stocks.domain.rabc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

@Entity
@Table(name = "sys_res_operation")
public class ResOperation extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6794922686618218171L;

	@Column
	private String code;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column(name = "deleted", columnDefinition="TINYINT(1)")
	private Boolean deleted;//是否可用
	
	@Column(name = "show", columnDefinition="TINYINT(1)")
	private Boolean show;//是否在权限管理显示

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
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

	public void setName(String name) {
		this.name = name;
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
