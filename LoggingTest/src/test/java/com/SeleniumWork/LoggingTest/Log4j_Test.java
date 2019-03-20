package com.SeleniumWork.LoggingTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j_Test {
	private static Logger log = LogManager.getLogger(Log4jTest.class.getName());
	public static void main(String[] args) {

		log.debug("This is DEBUG");
		log.info("This is INFO");
		log.error("This is ERROR");
		log.fatal("This is FATAL");

	}

}
