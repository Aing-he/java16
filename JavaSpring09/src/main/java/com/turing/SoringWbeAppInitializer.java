package com.turing;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.turing.config.RootConfig;
import com.turing.config.WebConfig;

public class SoringWbeAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	//SpringMVC≈‰÷√œÓ£¨DiaperServlet
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	
}
