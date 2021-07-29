package com.ch.jobdamoa.scrapcheck;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import com.ch.jobdamoa.scrapping.ExecScrapping;

public class ExecScrapPy {
	
	private static final Logger logger = LoggerFactory.getLogger(ExecScrapPy.class);
	
	@Scheduled(cron="0 0/5 * * * *")
	public void doScrapPy() {
		 Calendar calendar = Calendar.getInstance();
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 logger.info("스케줄 실행 : " + dateFormat.format(calendar.getTime()));
		 
		 // 5분마다 주기적으로 실행하는 프로세스
		 ExecScrapping es = new ExecScrapping();
		 es.doScrapping();
		 Calendar calendar2 = Calendar.getInstance();
		 logger.info("스케줄 종료 : " + dateFormat.format(calendar2.getTime()));
	}
}
