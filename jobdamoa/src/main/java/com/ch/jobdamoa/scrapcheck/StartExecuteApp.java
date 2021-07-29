package com.ch.jobdamoa.scrapcheck;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ch.jobdamoa.scrapping.Scrapping;

// 서버 시작 후 컨텍스트 초기화 후에 실행되는 구조
@Component
public class StartExecuteApp implements ApplicationListener<ContextRefreshedEvent>{
	
	private static final Logger logger = LoggerFactory.getLogger(StartExecuteApp.class);
	
	@Autowired
	private Scrapping sc;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("서버 시작 : " + dateFormat.format(calendar.getTime()));
		
		// 서버 시작과 동시에 스크래핑 구동
		sc.doScrapping(); // 프로그래머스
	}

}
