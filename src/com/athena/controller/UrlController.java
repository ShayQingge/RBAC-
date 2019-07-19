package com.athena.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athena.service.UrlService;

@Controller
public class UrlController {
	@Resource
	private UrlService urlServiceImpl;
	
	@RequestMapping("showAllUrl")
	public String showAll() {
		return "redirect:/main.jsp";
	}
}
