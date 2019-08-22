package com.myapp.config;

import javax.servlet.*;
import java.io.IOException;

/**
 * 当有请求访问该 Servlet 的时候，init 该 Servlet
 * @author qiaofei@css.com.cn
 * @version 1.0
 * @description
 * @createTime 15:08 2019/8/22
 * @modifyTime
 */
public class MyServlet implements Servlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println(MyServlet.class.getName() + " --- init ");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}
}
