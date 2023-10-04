package com.ssafy.mvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	// "regist" 이라는 GET 요청이 들어왔을 때 regist.jsp로 보내고 싶다.
	@GetMapping("regist")
	public String registForm() {
		// 로그인 유무를 파악하고 안했으면 돌아가
		return "regist";
	}
	
	@PostMapping("regist")
	public String regist() {
		// 예시로 서비스를 호출해서 등록을 한다..
		return "index";
	}
	
	
	@GetMapping("login")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping("login")
	// 이름 다르면 @RequestParam()으로 이름 바꿔줄 수도 있음
	// User 객체를 만들어서 직접 넣어줄 수도 있다
	
	// HttpServletRequest request 하고 HttpSession session = request.getSession(); 써도됨
	// HttpSession session
	public String login(HttpSession session, String id, String pw) {
		
		// user 관련 service를 호출해서 직접 사용자가 맞는지 체크 필요
		// 원래였으면 여기서 service 작성하면 안됨
		if (id.equals("ssafy") && pw.equals("1234")) {
			session.setAttribute("id", id); // 맞다면 session의 attribute에 id 저장
			return "redirect:/";
		}
		
		// 아니라면 로그인 페이지로 다시 가라
		return "redirect:/login";
		
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		// 세션에서 attribute 정보 삭제
		session.removeAttribute("id");
//		session.invalidate();
		return "redirect:/";
	}
	
}
