package com.ch.jobdamoa.scrapcheck;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class ExecScrapPy {
	
	private static final Logger logger = LoggerFactory.getLogger(ExecScrapPy.class);
	
	@Scheduled(cron="0 0/5 * * * *")
	public void doScrapPy() {
		 Calendar calendar = Calendar.getInstance();
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 logger.info("스케줄 실행 : " + dateFormat.format(calendar.getTime()));
		 Scrapping sc = new Scrapping();
		 sc.doProgrammers();
	}
}
