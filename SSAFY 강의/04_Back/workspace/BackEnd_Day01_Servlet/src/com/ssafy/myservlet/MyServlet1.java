package com.ssafy.myservlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//해당 클래스를 서블릿으로 만들기 위해서는 !!! Servlet을 구현해야한다.
public class MyServlet1 implements Servlet {

	@Override
	public void destroy() {
		//서블릿이 소멸될때 동작할것 같아.
	}

	@Override
	public ServletConfig getServletConfig() {
		//서블릿 설정을 반환하는거 같아.
		return null;
	}

	@Override
	public String getServletInfo() {
		//서블릿의 정보를 문자열로 반환하는거 같아.
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		//서블릿을 초기화 하는것 같아.
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//여기에서 요청과 응답 같은것을 처리 하는것 같아.
	}

}
