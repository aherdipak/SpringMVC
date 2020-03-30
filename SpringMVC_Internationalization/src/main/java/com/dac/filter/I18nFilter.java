package com.dac.filter;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
public class I18nFilter implements Filter {
	
	public void doFilter(ServletRequest requests, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        HttpServletRequest request = (HttpServletRequest) requests;
        String acceptLanguage = request.getHeader("Accept-Language");

        Locale lang = checkDefaultLang(acceptLanguage);

        Map<String, String[]> additionalParams = new TreeMap<String, String[]>();
        String[] langs = { lang.getLanguage() };
        additionalParams.put("siteLanguage", langs);
        HttpServletRequestWrapper enhancedHttpRequest = new ServletRequestModifier((HttpServletRequest) request, additionalParams);
		
		// pass the request along the filter chain
		chain.doFilter(enhancedHttpRequest, response);
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
	
	public void destroy() {	}
	public void init(FilterConfig filterConfig) throws ServletException { }
}
