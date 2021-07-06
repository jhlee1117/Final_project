package com.ch.jobdamoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ch.jobdamoa.service.AnnouncementService;

@Controller
public class AnnouncementController {
	
	@Autowired
	private AnnouncementService as;
}
