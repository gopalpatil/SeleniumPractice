package com.SeleniumWork.LoggingTest;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;

public class Log4jTest {
	
	private static Logger log = LogManager.getLogger(Log4jTest.class.getName());
	@Test
	public void displayLogs()
	{

		log.debug("This is DEBUG");
		log.info("This is INFO");
		log.error("This is ERROR");
		log.fatal("This is FATAL");
			

	}

}
