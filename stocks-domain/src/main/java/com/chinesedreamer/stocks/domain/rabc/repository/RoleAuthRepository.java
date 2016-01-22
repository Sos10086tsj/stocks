package com.chinesedreamer.stocks.domain.rabc.repository;

import java.util.Collection;
import java.util.List;

import com.chinesedreamer.stocks.domain.base.jpa.BaseRepository;
import com.chinesedreamer.stocks.domain.rabc.model.RoleAuth;

public interface RoleAuthRepository extends BaseRepository<RoleAuth, Long>{
	public List<RoleAuth> findByRoleCodeIn(Collection<String> roleCodes);
}
