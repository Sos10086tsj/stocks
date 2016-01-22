package com.chinesedreamer.stocks.domain.rabc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

@Entity
@Table(name = "sys_resource")
public class Resource extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9063629375726403389L;

	@Column
	private String code;//唯一code
	
	@Column
	private String name;//显示名称
	
	@Column
	private String description;//资源描述
	
	@Column
	private String url;//资源访问路径
	
	@Column
	private String icon;//资源显示图片
	
	@Column(name = "parent_code")
	private String parentCode;//上级资源路径
	
	@Column
	private Integer seq;//排序
	
	@Column(name = "show", columnDefinition="TINYINT(1)")
	private Boolean show;
	
	@Column(name = "deleted", columnDefinition="TINYINT(1)")
	private Boolean deleted;

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getUrl() {
		return url;
	}

	public String getIcon() {
		return icon;
	}

	public String getParentCode() {
		return parentCode;
	}

	public Integer getSeq() {
		return seq;
	}

	public Boolean getShow() {
		return show;
	}

	public Boolean getDeleted() {
		return deleted;
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

	public void setUrl(String url) {
		this.url = url;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	
	
}
