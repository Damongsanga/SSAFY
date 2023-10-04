package com.ssafy.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.dto.Person;
import com.ssafy.manager.PersonManager;

@WebServlet("/main")
public class MainServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		doProcess(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		switch (action) {
		case "regist":
			doRegist(req, resp);
			break;
		case "list":
			doList(req, resp);
			break;
		default:
			break;
		}
		
	}


	private void doList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersonManager pm = PersonManager.getInstance();
		
		req.setAttribute("list", pm.getAll());
		req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
	}


	private void doRegist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		String[] hobbies = req.getParameterValues("hobby");
		
		Person p = new Person(name, age, gender, hobbies);
		
		PersonManager pm = PersonManager.getInstance();
		pm.regist(p);
		
		
		req.setAttribute("person", p);
		
		RequestDispatcher disp = req.getRequestDispatcher("/result.jsp");
		disp.forward(req, resp);
		
		
//		resp.sendRedirect(req.getContextPath()+"/result.jsp?");
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
