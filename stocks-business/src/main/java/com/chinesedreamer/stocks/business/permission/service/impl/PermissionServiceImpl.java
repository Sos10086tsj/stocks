package com.chinesedreamer.stocks.business.permission.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.permission.logic.AuthResOprLogic;
import com.chinesedreamer.stocks.business.permission.logic.AuthorityLogic;
import com.chinesedreamer.stocks.business.permission.logic.ResourceLogic;
import com.chinesedreamer.stocks.business.permission.logic.RoleAuthLogic;
import com.chinesedreamer.stocks.business.permission.logic.RoleLogic;
import com.chinesedreamer.stocks.business.permission.logic.UserRoleLogic;
import com.chinesedreamer.stocks.business.permission.service.PermissionService;
import com.chinesedreamer.stocks.business.permission.vo.MenuNode;
import com.chinesedreamer.stocks.business.user.logic.UserLogic;
import com.chinesedreamer.stocks.domain.rabc.model.AuthResOperation;
import com.chinesedreamer.stocks.domain.rabc.model.Authority;
import com.chinesedreamer.stocks.domain.rabc.model.Role;
import com.chinesedreamer.stocks.domain.rabc.model.RoleAuth;
import com.chinesedreamer.stocks.domain.user.model.User;
import com.chinesedreamer.stocks.domain.user.model.UserRole;

@Service
public class PermissionServiceImpl implements PermissionService{
	
	private Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);
	
	@Resource
	private UserRoleLogic userRoleLogic;
	@Resource
	private RoleAuthLogic roleAuthLogic;
	@Resource
	private UserLogic userLogic;
	@Resource
	private RoleLogic roleLogic;
	@Resource
	private AuthResOprLogic authResOprLogic;
	@Resource
	private AuthorityLogic authorityLogic;
	@Resource
	private ResourceLogic resourceLogic;

	@Override
	public List<MenuNode> getUserMenu(Long userId) {
		//1. 获取用户所有角色
		List<UserRole> userRoles = this.userRoleLogic.getUserRole(userId);
		if (userRoles.isEmpty()) {
			User user = this.userLogic.findOne(userId);
			this.logger.info("User:{} hasn't apply any role, please contact system administrator to apply role before login.", user.getName());
			return new ArrayList<MenuNode>();
		}
		//2. 获取所有权限
		Set<String> roleCodes = new HashSet<String>();
		for (UserRole ur : userRoles) {
			Role role = this.roleLogic.getAvailableRole(ur.getId());
			if (null != role) {
				roleCodes.add(role.getCode());
			}
		}
		if (roleCodes.isEmpty()) {
			User user = this.userLogic.findOne(userId);
			this.logger.info("User:{} hasn't apply any available role, please contact system administrator to apply available role before login.", user.getName());
			return new ArrayList<MenuNode>();
		}
		List<RoleAuth> roleAuths = this.roleAuthLogic.getRoleAuths(roleCodes);
		if (roleAuths.isEmpty()) {
			User user = this.userLogic.findOne(userId);
			this.logger.info("User:{} has no authority, please contact system administrator to apply available role before login.", user.getName());
			return new ArrayList<MenuNode>();
		}
		//3. 获取所有资源
		Set<String> authCodes = new HashSet<String>();
		for (RoleAuth ra : roleAuths) {
			Authority authority = this.authorityLogic.getByCodeAvailable(ra.getAuthCode());
			if (null != authority) {
				authCodes.add(ra.getAuthCode());
			}
		}
		if (authCodes.isEmpty()) {
			User user = this.userLogic.findOne(userId);
			this.logger.info("User:{} has no available authority, please contact system administrator to apply available authority before login.", user.getName());
			return new ArrayList<MenuNode>();
		}
		List<AuthResOperation> authResOperations = this.authResOprLogic.getByAuthCodes(authCodes);
		Set<String> resCodes = new HashSet<String>();
		for (AuthResOperation aro : authResOperations) {
			com.chinesedreamer.stocks.domain.rabc.model.Resource resource = this.resourceLogic.getAvailableByCode(aro.getResCode());
			if (null != resource) {
				resCodes.add(aro.getResCode());
			}
		}
		if (resCodes.isEmpty()) {
			User user = this.userLogic.findOne(userId);
			this.logger.info("User:{} has no available resource, please contact system administrator to apply available resource before login.", user.getName());
			return new ArrayList<MenuNode>();
		}
		List<com.chinesedreamer.stocks.domain.rabc.model.Resource> resources = this.resourceLogic.getAvaliableByCodesInOrder(resCodes);
		//TODO
		
		// TODO Auto-generated method stub
		return null;
	}

}
