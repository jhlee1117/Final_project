package com.ch.jobdamoa.scrapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class ExecScrapping implements Scrapping {

	private static String path = "python D:\\my_project\\final_project\\jobdamoa\\src\\main\\webapp\\python_scrap";
	
	public void doProgrammers() {

		String filename = "scrapper.py";
		Process pc = null; // 프로세스를 실행할 주체
		Runtime rt = Runtime.getRuntime();
		String line;
		
		try {
			
			pc = rt.exec(path + "\\" + filename);
			System.out.println("프로그래머스 스크래핑 시작");
			BufferedReader br = new BufferedReader(new InputStreamReader(pc.getInputStream()));

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
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