package com.gestion.stock.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

public class ApplicationUtils {

	private ApplicationUtils() {}
	public static void changeLocale(HttpServletRequest request, HttpServletResponse response, String Locale) {
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		localeResolver.setLocale(request,response,StringUtils.parseLocaleString(Locale));
	}
	
}
