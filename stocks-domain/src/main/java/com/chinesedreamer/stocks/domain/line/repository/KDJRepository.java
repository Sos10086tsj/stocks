package com.chinesedreamer.stocks.domain.line.repository;

import com.chinesedreamer.stocks.domain.base.jpa.BaseRepository;
import com.chinesedreamer.stocks.domain.line.constant.KDJType;
import com.chinesedreamer.stocks.domain.line.model.KDJ;

public interface KDJRepository extends BaseRepository<KDJ, Long>{
	public KDJ findByDateAndTypeAndStockCode(Integer date,KDJType type,String stockCode);
}
