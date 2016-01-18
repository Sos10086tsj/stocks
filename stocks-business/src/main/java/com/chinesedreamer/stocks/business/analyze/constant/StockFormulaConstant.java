package com.chinesedreamer.stocks.business.analyze.constant;

public class StockFormulaConstant {

	public static class KDJ {
		public final static Integer DEFAULT_YESTERDAY_SCOPE = 10;
		public final static Integer KDJ_CALCULATE_SCALE = 4;
		public final static Integer KDJ_RESULT_SCALE = 2;
	}
	
	public static class MA {
		public final static Integer DAY_SCOPE_DEFAULT = 9;
		public final static Integer DAY_SCOPE_5 = 5;
		public final static Integer DAY_SCOPE_10 = 10;
		public final static Integer DAY_SCOPE_20 = 20;
		public final static Integer DAY_SCOPE_30 = 30;
		public final static Integer DAY_SCOPE_60 = 60;
		
		public final static Integer MA_CALCULATE_SCALE = 4;
		public final static Integer MA_RESULT_SCALE = 2;
	}
}
