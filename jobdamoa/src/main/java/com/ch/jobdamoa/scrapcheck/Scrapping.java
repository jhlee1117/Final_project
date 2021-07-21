package com.ch.jobdamoa.scrapcheck;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class Scrapping {

	private static String path = "python D:\\my_project\\final_project\\jobdamoa\\src\\main\\webapp\\python_scrap";
	
	public void doProgrammers() {
		
		String filename = "save.py";
		
		Process pc = null; // 프로세스를 실행할 주체
		Runtime rt = Runtime.getRuntime();
		
		try {
			pc = rt.exec(path + "\\" + filename);
			System.out.println("프로그래머스 스크래핑 시작");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				pc.waitFor();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			System.out.println("프로그래머스 스크래핑 완료");
			pc.destroy();
		}
		
	}
}
