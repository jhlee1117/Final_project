package com.ch.jobdamoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ch.jobdamoa.service.ManagerService;

@Controller
public class ManagerController {

	@Autowired
	private ManagerService ms;
}
