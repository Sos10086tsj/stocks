package com.chinesedreamer.stocks.domain.rabc.repository;

import java.util.Collection;
import java.util.List;

import com.chinesedreamer.stocks.domain.base.jpa.BaseRepository;
import com.chinesedreamer.stocks.domain.rabc.model.AuthResOperation;

public interface AuthResOperationRepository extends BaseRepository<AuthResOperation, Long>{
	public List<AuthResOperation> findByAuthCodeIn(Collection<String> authCodes);
}
