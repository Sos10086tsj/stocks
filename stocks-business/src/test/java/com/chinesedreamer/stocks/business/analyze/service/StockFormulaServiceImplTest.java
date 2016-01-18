package com.chinesedreamer.stocks.business.analyze.service;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.chinesedreamer.stocks.business.base.BaseTest;
import com.chinesedreamer.stocks.domain.line.constant.KDJType;
import com.chinesedreamer.stocks.domain.line.model.KDJ;
import com.chinesedreamer.stocks.domain.line.model.MA;
import com.chinesedreamer.stocks.domain.line.model.MACD;

public class StockFormulaServiceImplTest extends BaseTest{
	@Resource
	private StockFormulaSevice stockFormulaSevice;

	@Test
//	@Rollback(value = false)
	public void testGenerateKdj() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, 0, 5);
		KDJ kdj = this.stockFormulaSevice.generateKdj("002024", KDJType.DAY, calendar.getTime());
		assertNotNull(kdj);
		System.out.println("*************************" + kdj);
	}

	@Test
//	@Rollback(value = false)
	public void testGenerateMa(){
		System.out.println(">>>>>>>>>>>>> start");
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, 0, 5);
		MA ma = this.stockFormulaSevice.generateMa("002024", calendar.getTime());
		assertNotNull(ma);
		System.out.println("*************************" + ma);
	}
	
	@Test
	@Rollback(value = false)
	public void testGenerateMacd(){
		System.out.println(">>>>>>>>>>>>> start");
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, 0, 5);
		MACD macd = this.stockFormulaSevice.generateMacd("002024", calendar.getTime());
		assertNotNull(macd);
		System.out.println("*************************" + macd);
	}
}
