package com.dac.filter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.util.WebUtils;



public class I18nFilterTest {//implements Filter {
	
	 public void doFilter(ServletRequest reqs, ServletResponse res, FilterChain chain)
	            throws IOException, ServletException {

	        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

	        HttpServletRequest request = (HttpServletRequest) reqs;

	        String acceptLanguage = request.getHeader("Accept-Language");

	        Locale lang = checkDefaultLang(acceptLanguage);

	        Map<String, String[]> allParameters = new TreeMap<String, String[]>();
	        String[] langs = { lang.getLanguage() };
	        allParameters.put("lang", langs);

	        
	        //HttpServletRequestWrapper req = new AddLanguageRequest(request, allParameters);// request modifier class created by user
	        HttpServletRequestWrapper req = null;
	        
	        HttpSession session = request.getSession();
	        String errorMsg = null;
	        String path = ((HttpServletRequest) req).getRequestURI().substring(((HttpServletRequest) req).getContextPath().length());
	        
	       
	        try {
	                if ((path.endsWith("css") || (path.endsWith("zip")) || path.endsWith("js") || path.endsWith("ttf")
	                                || path.endsWith("woff") || path.contains("woff2") || path.endsWith("ico")
	                                || path.endsWith("png") || path.endsWith("bmp") || path.endsWith("jpg")
	                                || path.endsWith("gif"))) {
	                   // check data
	                	chain.doFilter(req, res);
	                } else {
	                    chain.doFilter(req, res);
	                }
	                
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }// DOfilter

	    
	    public void init(FilterConfig filterConfig) throws ServletException {
	        System.out.println("Init filter");
	    }

	    private Locale checkDefaultLang(String acceptLanguage) {
	        Locale lang = null;
	        try {
	            if (acceptLanguage.contains(",")) {
	                String[] aheader = acceptLanguage.split(",[ ]*");
	                for (String locale : aheader) {
	                    lang = Locale.forLanguageTag(locale);
	                    if (lang != null) {
	                        break;
	                    }
	                }
	            } else if (!acceptLanguage.contains(",") && !acceptLanguage.isEmpty()) {
	                lang = Locale.forLanguageTag(acceptLanguage);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        if (lang == null) {
	            Locale.getDefault();
	        }
	        return lang;
	    }

		public void destroy() {
		}

}
