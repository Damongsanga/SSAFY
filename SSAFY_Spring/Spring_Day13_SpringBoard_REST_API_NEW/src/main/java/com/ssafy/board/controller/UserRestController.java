package com.ssafy.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api-user")
@Api(tags = "유저 컨트롤러") // 설명 ~ 필수 아님 ~
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("users")
	public List<User> userList() {
		return userService.getUserList();
	}
	
	//form tag로 넘어왔다면 @RequestBody 필요 없음 (JSON이면 필요함)
	@PostMapping("signup")
	public ResponseEntity<Integer> signup(User user) {
		int result = userService.signup(user);
		
		//result == 1 : 등록
		//result == 0 : 실패
		
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}

	// 백엔드에서 결과만 확인해줌
	@PostMapping("login")
	public ResponseEntity<?> login(User user, HttpSession session) {
		User loginUser = userService.login(user);
		if (loginUser != null) {
			session.setAttribute("loginUser", loginUser.getId());
			return new ResponseEntity<String>(loginUser.getName(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	}
	
	
	@GetMapping("logout")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
