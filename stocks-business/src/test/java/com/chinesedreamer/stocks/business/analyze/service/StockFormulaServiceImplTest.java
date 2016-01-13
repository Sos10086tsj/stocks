package com.chinesedreamer.stocks.business.analyze.service;

import static org.junit.Assert.*;

import java.util.Calendar;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.chinesedreamer.stocks.business.base.BaseTest;
import com.chinesedreamer.stocks.domain.line.constant.KDJType;
import com.chinesedreamer.stocks.domain.line.model.KDJ;

public class StockFormulaServiceImplTest extends BaseTest{
	@Resource
	private StockFormulaSevice stockFormulaSevice;

	@Test
	@Rollback(value = false)
	public void testGenerateKdj() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, 0, 5);
		KDJ kdj = this.stockFormulaSevice.generateKdj("002024", KDJType.DAY, calendar.getTime());
		assertNotNull(kdj);
		System.out.println("*************************" + kdj);
	}

}
