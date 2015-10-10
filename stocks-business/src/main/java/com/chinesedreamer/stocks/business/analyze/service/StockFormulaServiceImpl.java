package com.chinesedreamer.stocks.business.analyze.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.common.util.DateUtil;
import com.chinesedreamer.stocks.domain.line.constant.KDJType;
import com.chinesedreamer.stocks.domain.line.model.KDJ;
import com.chinesedreamer.stocks.domain.line.repository.KDJRepository;
import com.chinesedreamer.stocks.domain.stock.model.StockIndex;
import com.chinesedreamer.stocks.domain.stock.repository.StockIndexRepository;

@Service
public class StockFormulaServiceImpl implements StockFormulaSevice{
	
	@Resource
	private StockIndexRepository stockIndexRepository;
	@Resource
	private KDJRepository repostory;
	@Resource
	private WarningService warningService;

	@Override
	public KDJ generateKdj(String stockCode,KDJType type, Date date) {
		//1. 获取股票当日指数信息
		StockIndex si = this.stockIndexRepository.findByDateAndStockCode(Integer.valueOf(DateUtil.getFormatTime("yyyyMMdd",date)), stockCode);
		//2. 获取rsv
		BigDecimal rsv = (si.getClosePrice().subtract(si.getTodayMin())).divide((si.getTodayMax().subtract(si.getTodayMin())));
		//3. 获取前一日kdj
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		KDJ yesterdayKdj = this.repostory.findByDateAndTypeAndStockCode(Integer.valueOf(DateUtil.getFormatTime("yyyyMMdd",calendar.getTime())), type, stockCode);
		BigDecimal yesterdayK = new BigDecimal(50);
		BigDecimal yesterdayD = new BigDecimal(50);
		if (null != yesterdayKdj) {
			yesterdayK = yesterdayKdj.getK();
			yesterdayD = yesterdayKdj.getD();
		}
		BigDecimal k = yesterdayK.multiply(new BigDecimal(2)).divide(new BigDecimal(3)).add(rsv.divide(new BigDecimal(3)));
		BigDecimal d = yesterdayD.multiply(new BigDecimal(2)).divide(new BigDecimal(3)).add(k.divide(new BigDecimal(3)));
		BigDecimal j = k.multiply(new BigDecimal(3)).subtract(d.multiply(new BigDecimal(2)));
		KDJ kdj = this.repostory.findByDateAndTypeAndStockCode(Integer.valueOf(DateUtil.getFormatTime("yyyyMMdd",date)), type, stockCode);
		if (null == kdj) {
			kdj = new KDJ();
		}
		kdj.setD(d);
		kdj.setDate(Integer.valueOf(DateUtil.getFormatTime("yyyyMMdd",date)));
		kdj.setJ(j);
		kdj.setK(k);
		kdj.setRsv(rsv);
		kdj.setStockCode(stockCode);
		kdj.setType(type);
		//4. 交由提醒task处理kdj
		this.warningService.kdjWarning(kdj);
		return this.repostory.save(kdj);
	}

}
