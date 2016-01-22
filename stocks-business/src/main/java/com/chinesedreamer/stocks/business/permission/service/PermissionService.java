package com.chinesedreamer.stocks.business.permission.service;

import java.util.List;

import com.chinesedreamer.stocks.business.permission.vo.MenuNode;

/**
 * 系统权限相关service
 * @author Paris
 *
 */
public interface PermissionService {
	/**
	 * 获取用户menu tree
	 * @param userId
	 * @return
	 */
	public List<MenuNode> getUserMenu(Long userId);
}
