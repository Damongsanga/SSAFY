package com.ssafy.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.model.dto.User;

@RestController
@RequestMapping("/rest3")
public class TestController3 {
	
	

	// http://localhost:8080/mvc/rest3/test1
	@GetMapping("test1")
	public String test1() {
		return "hi GET";
	}

	// http://localhost:8080/mvc/rest3/test2
	@PostMapping("test2")
	public String test2() {
		return "hi POST";
	}

	// http://localhost:8080/mvc/rest3/test3
	@PutMapping("test3")
	public String test3() {
		return "hi PUT";
	}

	// http://localhost:8080/mvc/rest3/test4
	@DeleteMapping("test4")
	public String test4() {
		return "hi DELETE";
	}

}
