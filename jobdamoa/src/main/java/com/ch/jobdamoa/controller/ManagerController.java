package com.ch.jobdamoa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.jobdamoa.model.Company;
import com.ch.jobdamoa.model.Manager;
import com.ch.jobdamoa.model.Member;
import com.ch.jobdamoa.service.ManagerService;

@Controller
public class ManagerController {

	@Autowired
	private ManagerService ms;
}
