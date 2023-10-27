package com.ssafy.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("users")
	public String userList(Model model) {
		model.addAttribute("userList", userService.getUserList());
		return "/user/userList";
	}
	
	@GetMapping("signup")
	public String signupForm() {
		return "/user/signupform";
	}

	@PostMapping("signup")
	public String signup(User user) {
		userService.signup(user);
		
		return "redirect:list";
	}
	
	@GetMapping("login")
	public String loginForm() {
		return "/user/loginform";
	}
	
	@PostMapping("login")
	public String login(User user, HttpSession session) {
		User loginUser = userService.login(user);
		if (loginUser != null) {
			session.setAttribute("loginUser", loginUser.getId());
			return "redirect:/list";
		}
		
		return "redirect:list";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:list";
	}
}
