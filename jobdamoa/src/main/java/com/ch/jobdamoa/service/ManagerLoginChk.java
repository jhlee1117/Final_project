package com.ch.jobdamoa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ManagerLoginChk extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		System.out.println("manager_num1:" + session.getAttribute("manager_num"));
		System.out.println("user_dist1:" + session.getAttribute("user_dist"));
		if (session.getAttribute("manager_num") == null && session.getAttribute("user_dist") != "2") {
			System.out.println("manager_num2:" + session.getAttribute("manager_num"));
			System.out.println("user_dist2:" + session.getAttribute("user_dist"));
			response.sendRedirect("memberLoginForm.do");
			// 원래 요청했던 작업 취소
			return false;  
		}
		return true;
	}
}
