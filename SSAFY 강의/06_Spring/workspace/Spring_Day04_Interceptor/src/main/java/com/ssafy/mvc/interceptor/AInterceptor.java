package com.ssafy.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 인터셉터로 만들기 위해서는
// 1. 구현 : implements HandlerInterceptor
// 2. 상속 : extends HandlerInterceptorAdapter

public class AInterceptor implements HandlerInterceptor{
	
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("A : preHandle");

		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			 ModelAndView modelAndView) throws Exception {
		System.out.println("A : postHandle");
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			 Exception ex) throws Exception {
		System.out.println("A : afterCompletion");
	}
}
