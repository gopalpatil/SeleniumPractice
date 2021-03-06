package com.SeleniumWork.MavenTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Log4jTest_1 {
	
	private static Logger log = LogManager.getLogger(Log4jTest_1.class.getName());
	
	@Test
	public void displayLogs()
	{	log.debug("This is DEBUG");
		log.info("This is INFO");
		log.error("This is ERROR");
		log.fatal("This is FATAL");
	}
}
