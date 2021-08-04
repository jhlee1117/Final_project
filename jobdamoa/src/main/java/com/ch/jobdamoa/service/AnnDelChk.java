package com.ch.jobdamoa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AnnDelChk extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		System.out.println("세션체크 후:" + session.getAttribute("user_dist"));
		if (session.getAttribute("user_dist") != null) {
			if (session.getAttribute("user_dist") == "1" && session.getAttribute("com_num") == null) {
				response.sendRedirect("companyLoginForm.do");
				return false; 
			} else if (session.getAttribute("user_dist") == "2" && session.getAttribute("manager_num") == null) {
				response.sendRedirect("memberLoginForm.do");
				return false; 
			}
		} else if (session.getAttribute("user_dist") == null) {
			response.sendRedirect("annFail.do");
			return false;
		}
		return true;
	}
}
