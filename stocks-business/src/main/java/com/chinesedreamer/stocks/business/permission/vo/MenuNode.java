package com.chinesedreamer.stocks.business.permission.vo;

import java.util.List;

public class MenuNode {
	private String name;
	private String url;
	private String icon;
	private List<MenuNode> subMenu;
	public String getName() {
		return name;
	}
	public String getUrl() {
		return url;
	}
	public String getIcon() {
		return icon;
	}
	public List<MenuNode> getSubMenu() {
		return subMenu;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public void setSubMenu(List<MenuNode> subMenu) {
		this.subMenu = subMenu;
	}
	@Override
	public String toString() {
		return "MenuNode [name=" + name + ", url=" + url + ", icon=" + icon + ", subMenu=" + subMenu + "]";
	}
	
	
}
