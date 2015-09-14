package com.chinesedreamer.stocks.domain.sysconfig.repository;

import com.chinesedreamer.stocks.domain.base.jpa.BaseRepository;
import com.chinesedreamer.stocks.domain.sysconfig.model.SysConfig;

public interface SysConfigRepository extends BaseRepository<SysConfig, Long>{
	public SysConfig findByProperty(String property);
}
