package com.chinesedreamer.stocks.domain.rabc.repository;

import com.chinesedreamer.stocks.domain.base.jpa.BaseRepository;
import com.chinesedreamer.stocks.domain.rabc.model.Authority;

public interface AuthorityRepository extends BaseRepository<Authority, Long>{
	public Authority findByCode(String code);
	public Authority findByCodeAndDeletedFalse(String code);
}
