package com.ch.jobdamoa.scrapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class ExecScrapping implements Scrapping {

	private static String path = "python C:\\my_project\\spring\\final_project\\jobdamoa\\src\\main\\webapp\\python_scrap";

	public void doScrapping() {

		String filename = "scrapper.py";
		Process pc = null; // 프로세스를 실행할 주체
		Runtime rt = Runtime.getRuntime();
		String line;

		try {

			pc = rt.exec(path + "\\" + filename);
			System.out.println("스크래핑 프로세스 실행");

			BufferedReader br = new BufferedReader(new InputStreamReader(pc.getInputStream(), "EUC-KR"));
			BufferedReader brErr = new BufferedReader(new InputStreamReader(pc.getErrorStream(), "EUC-KR"));

			if (br.readLine() != null) {
				System.out.println("=== 스크래핑 프로세스 정상 ===");
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} else
				System.out.println("=== 스크래핑 프로세스 오류 ===");
				while ((line = brErr.readLine()) != null) {
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
			System.out.println("스크래핑 프로세스 완료");
			pc.destroy();
		}
	}
}