package com.ssafy.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.model.dto.User;

@RestController
@RequestMapping("/rest4")
public class TestController4 {
	
	// 게시글 선택
	// @PathVariable 명시
//	@GetMapping("/board/{id}")
//	public String test1(@PathVariable int id) {
//		return "GET " + id;
//	}
	
	// 변수명이 일치하지 않으면 @PathVariable에 명시해줘야
	@GetMapping("/board/{id}")
	public String test1(@PathVariable("id") int no) {
		return "GET " + no;
	}

	// 게시글 등록
	// application/x-www-form-urlencoded : 폼으로 보냈더니 잘 등록이 됨
//	@PostMapping("/board")
//	public String test2(User user) {
//		return user.toString();
//	}
	
	// JSON 형태로 보내는 경우
//	{
//		"name"  : "younha",
//		"id" : "ssafy", 
//		"password" : "486"
//		
//	}
	
	@PostMapping("/board")
	public String test3(@RequestBody User user) {
		return user.toString();
	}
	
	@GetMapping("/test4")
	public ResponseEntity<String> test4(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("auth", "admin");
		
		// 응답하려고 하는 데이터, 응답 상태 코드, 응답 헤더 같은 것들을 넣을 수 있음
		return new ResponseEntity<String>("OK data", headers, HttpStatus.OK);
	}

}
