package com.ch.jobdamoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ch.jobdamoa.service.FavoritesService;

@Controller
public class FavoritesController {

	@Autowired
	private FavoritesService fs;
}
