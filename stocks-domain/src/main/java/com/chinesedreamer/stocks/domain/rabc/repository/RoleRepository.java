package com.chinesedreamer.stocks.domain.rabc.repository;

import com.chinesedreamer.stocks.domain.base.jpa.BaseRepository;
import com.chinesedreamer.stocks.domain.rabc.model.Role;

public interface RoleRepository extends BaseRepository<Role, Long>{
	public Role findByDeletedFalse();
}
