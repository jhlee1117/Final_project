package com.ch.jobdamoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ch.jobdamoa.service.ScrapService;

@Controller
public class ScrapController {

	@Autowired
	private ScrapService ss;
}
