<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("password");
	
	//실제로는 id와 pw를 가지고 DB와 통신을 한 후 실제로 우리의 유저인지를 확인하는 과정이 필요함.
	if(id.equals("ssafy") && pw.equals("1234")){
		//로그인 성공이야.
		//(Servlet 기준) 세션을 얻어오고 해당 세션에 저장한다.
		//HttpSession session = request.getSession();
		session.setAttribute("loginUser", id); // id 혹은 닉네임 혹은 이름 
		response.sendRedirect("main.jsp");
		//request.getRequestDispatcher("main.jsp").forward(request, response);
	}else{
		//로그인 실패 (로그인 폼으로 보내)
		response.sendRedirect("loginForm.jsp");
	}
	
	
	
%>