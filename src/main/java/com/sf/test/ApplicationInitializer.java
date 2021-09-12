package com.sf.test;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//bootstrap the dispatcher servlet
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(ApplicationConfiguration.class);
		ServletRegistration.Dynamic dynamic = servletContext.addServlet("swaggger",
				new DispatcherServlet(webApplicationContext));
		
		dynamic.setLoadOnStartup(1);
		dynamic.addMapping("/");
	
	}
}
