package com.chinesedreamer.stocks.domain.rabc.repository;

import java.util.Collection;
import java.util.List;

import com.chinesedreamer.stocks.domain.base.jpa.BaseRepository;
import com.chinesedreamer.stocks.domain.rabc.model.Resource;

public interface ResourceRepository extends BaseRepository<Resource, Long>{
	public Resource findByCodeAndDeletedFalse(String code);
	
	public List<Resource> findByCodeInAndDeletedFalse(Collection<String> codes);
}
