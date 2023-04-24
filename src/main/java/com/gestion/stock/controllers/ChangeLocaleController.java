package com.gestion.stock.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping(value="/changeLocale")
public class ChangeLocaleController {
	
	private static final String REFERER="referer";
	@RequestMapping(value="/{locale}")
	public String changeLocale(HttpServletRequest request, HttpServletResponse response,@PathVariable String locale) {
		if(!StringUtils.isNullOrEmpty(locale)) {
			
		}
		String lastUrl = request.getHeader(REFERER);
		if(!StringUtils.isNullOrEmpty(lastUrl)) {
			return "redirect:"+lastUrl;
		}
		
		
		return "redirect:/home";
	}
	
	
}
