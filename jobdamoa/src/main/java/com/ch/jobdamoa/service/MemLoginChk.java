package com.ch.jobdamoa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemLoginChk extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("mem_num") == null && session.getAttribute("user_dist") != "0") {
			response.sendRedirect("memberLoginForm.do");
			// 원래 요청했던 작업 취소
			return false;  
		}
		return true;
	}
}
