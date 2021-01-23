package com.cn.qingruan.hrsystem.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter {

	public LoginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		// ��ȡ��Դ����·��
		String uri = req.getRequestURI();
		if (uri.contains("/jsp/login.jsp") || uri.contains("/user/login") ||uri.contains("/static/img/")
				|| uri.contains("/css/") ||uri.contains("/css/font/")|| uri.contains("/js/")) {
			// ����
			chain.doFilter(req, response);
		} else {
			// ��ȡsession����
			Object user = req.getSession().getAttribute("result");
			if (user != null) {
				// ����
				chain.doFilter(req, response);
			} else {
				req.setAttribute("message", "����δ��¼�����ȵ�¼��");				
				req.getRequestDispatcher("/jsp/login.jsp").forward(req, response);
			}
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
