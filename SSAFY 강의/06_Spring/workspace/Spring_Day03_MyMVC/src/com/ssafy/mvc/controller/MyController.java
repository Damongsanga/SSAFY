package com.ssafy.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.MyService;

@Controller
public class MyController {
//	@Autowired
	private MyService myService;
	
	@Autowired
	public void setMyService(MyService myService) {
		this.myService = myService;
	}
	
	
	
	@RequestMapping("home")
//	@RequestMapping(value="home", method = RequestMethod.GET)
	public ModelAndView homeHandle() {
		ModelAndView mav = new ModelAndView();
		
		System.out.println("home 요청이 왔다.");
		
		myService.doSometing();
		
		//데이터를 심어서 보내보자
		//키와 벨류 형태로 넣는다.
		mav.addObject("msg", "Welcome to Spring MVC");
		
		
		//View 이름을 지정을 해주고 넘기자
		//포워딩을 한것과 같음.
		mav.setViewName("home");
		return mav;
	}
	
	
	//Get요청만을 위한것
	@GetMapping("test1")
	public String test1() {
		//반환타입이 String 이라면 반환값이 viewname이 된다.
		return "test1"; // /WEB-INF/view/test1.jsp
	}
	
	
	
	//반환타입을 문자열로 쓰고 데이터도 넘기고 싶어...
	@GetMapping("test2")
	public String test2(Model model) {
		model.addAttribute("msg", "데이터를 실어서 보냈습니다");
		return "test2";
	}
	
	//파라미터로 값을 받고 싶어.
	//사용자가 넘긴 파리미터의 키값이 내가 메서드로 작성한 값과 다르다면 @RequestParam(value="myid")String id
	//기본값으로는 Null 들어간다.
	@GetMapping("test3")
	public String test3(Model model, @RequestParam(value="myid")String id, String pw, @RequestParam(defaultValue = "1")int age) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		System.out.println(age);
		return "test3";
	}
	
	
	@PostMapping("test4")
	public String test4(Model model, User user) {
		System.out.println(user);
		return "test4";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
