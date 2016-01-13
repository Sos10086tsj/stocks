package com.chinesedreamer.stocks.business.analyze.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.analyze.vo.KdjC;
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
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Integer dateInt = Integer.valueOf(DateUtil.getFormatTime("yyyyMMdd",calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Integer yesterdayDateInt = Integer.valueOf(DateUtil.getFormatTime("yyyyMMdd",calendar.getTime()));
		
		KdjC kdjC = this.getKdjC(stockCode, dateInt, DEFAULT_YESTERDAY_SCOPE);
		BigDecimal rsv = (si.getClosePrice().subtract(kdjC.getLn())).multiply(new BigDecimal(100)).divide((kdjC.getHn().subtract(kdjC.getLn())),2);
		//3. 获取前一日kdj
		
		KDJ yesterdayKdj = this.repostory.findByDateAndTypeAndStockCode(yesterdayDateInt, type, stockCode);
		BigDecimal yesterdayK = new BigDecimal(50);
		BigDecimal yesterdayD = new BigDecimal(50);
		if (null != yesterdayKdj) {
			yesterdayK = yesterdayKdj.getK();
			yesterdayD = yesterdayKdj.getD();
		}
		
		BigDecimal zero = new BigDecimal("0");
		BigDecimal k = yesterdayK.multiply(new BigDecimal(2)).divide(new BigDecimal(3), 2).add(rsv.divide(new BigDecimal(3), 2));
		k = (k.compareTo(zero) <= 0) ? zero : k;
		BigDecimal d = yesterdayD.multiply(new BigDecimal(2)).divide(new BigDecimal(3), 2).add(k.divide(new BigDecimal(3), 2));
		d = (d.compareTo(zero) <= 0) ? zero : d;
		BigDecimal j = k.multiply(new BigDecimal(3)).subtract(d.multiply(new BigDecimal(2)));
		j = (j.compareTo(zero) <= 0) ? zero : j;
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
		//this.warningService.kdjWarning(kdj);
		return this.repostory.save(kdj);
	}

	private final Integer DEFAULT_YESTERDAY_SCOPE = 9;
	/**
	 * 获取前一日K值，默认9天
	 * @param stockCode
	 * @param type
	 * @param date
	 * @return
	 */
	private KdjC getKdjC(String stockCode,Integer date, Integer  yesterdayScop){
		List<StockIndex> stockIndexs = this.stockIndexRepository.findByDateLessThanEqualAndStockCodeOrderByDateDesc(date, stockCode, new PageRequest(0, yesterdayScop));
		
		KdjC kdjC = new KdjC();
		BigDecimal ln = null;
		BigDecimal hn = null;
		for (StockIndex si : stockIndexs) {
			if (null == ln) {
				ln = si.getTodayMin();
			}
			if (null == hn) {
				hn = si.getTodayMax();
			}
			if (si.getTodayMin().compareTo(ln) == -1) {
				ln = si.getTodayMin();
			}
			if (si.getTodayMax().compareTo(hn) == 1) {
				hn = si.getTodayMax();
			}
		}
		kdjC.setHn(hn);
		kdjC.setLn(ln);
		return kdjC;
	}
}
