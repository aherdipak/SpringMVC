package com.dac.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBaseAccessInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest req,
			HttpServletResponse resp,Object handler) throws Exception {
		// if this method returns true then - application will further handle the request.
		// if this method returns false then -  application will not further handle the request.
		
		Calendar cal =Calendar.getInstance();
		int dayOfWeek = cal.get(cal.DAY_OF_WEEK);      // getting the day on which request is made
		if(dayOfWeek == 1) {                           // 1 means Sunday,2 means Monday .... 7 means Saturday
			resp.getWriter().write("The website is closed on Sunday; Please try accessing it" +
					" on any other week day!!!");
			return false;
		}
		return true;
	}

}