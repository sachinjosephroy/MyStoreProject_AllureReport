package com.mystore.utility;

import org.apache.log4j.Logger;

public class Log {

	public static Logger Log = Logger.getLogger(Log.class.getName());

	public static void startTestCase(String sTestCaseName) {
		Log.info("=====================================" + sTestCaseName
				+ " TEST START=========================================");
	}

}
