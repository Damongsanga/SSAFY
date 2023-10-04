package com.ssafy.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/make")
public class MakeCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MakeCookieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		String value = request.getParameter("value");
		
//		System.out.println(key); //잘넘어온다.
		
		//쿠키를 생성하자.
		Cookie cookie = new Cookie(key, value);
		
		cookie.setMaxAge(10); ///초단위
		
		response.addCookie(cookie);
		
		
		response.sendRedirect("01_Cookie.jsp");
		
		
		
		
		
		
		
	}

}
