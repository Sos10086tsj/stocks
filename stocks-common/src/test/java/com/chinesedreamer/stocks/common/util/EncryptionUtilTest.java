package com.chinesedreamer.stocks.common.util;

import org.junit.Test;

public class EncryptionUtilTest {

	@Test
	public void testMd5L32() {
		//needIndex=0&showapi_appid=8855&showapi_timestamp=20150924133038&stocks=sh601006,sh601007,sh601008,sh601009,sz000018,hk00941
		//97c4365c6f34ae3dcaacb42a508ae061
		String a = "needIndex0showapi_appid8855showapi_timestamp20150924133038stockssh601006,sh601007,sh601008,sh601009,sz000018,hk00941de775a2c637f4006b1327b13271c619d";
		System.out.println(EncryptionUtil.md5L32(a));
	}

//	@Test
//	public void testGenerateSalt() {
//		fail("Not yet implemented");
//	}

}
