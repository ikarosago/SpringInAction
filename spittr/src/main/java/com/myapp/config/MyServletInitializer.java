package com.myapp.config;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author qiaofei@css.com.cn
 * @version 1.0
 * @description
 * @createTime 15:00 2019/8/22
 * @modifyTime
 */
public class MyServletInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
		myServlet.addMapping("/custom/*");
	}
}
