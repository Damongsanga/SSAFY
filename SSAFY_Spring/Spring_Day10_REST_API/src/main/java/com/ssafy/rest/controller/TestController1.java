package com.ssafy.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.model.dto.User;

@RestController
public class TestController1 {

	// http://localhost:8080/mvc/rest1/test1
	// view가 없음
	@GetMapping("rest1/test1")
	public String test1() {
		return "hi rest";
	}

	// http://localhost:8080/mvc/rest1/test2
	// @ResponseBody 사용하여 JSP 파일이 아닌 데이터 자체를 받음
	@ResponseBody
	@GetMapping("rest1/test2")
	public String test2() {
		return "hi rest";
	}

	// http://localhost:8080/mvc/rest1/test3
	// Map 형태 반환 불가능
	// JSON 형태로 변환해야 -> Jackson 사용
	@ResponseBody
	@GetMapping("rest1/test3")
	public Map<String, String> test3() {
		Map<String, String> data = new HashMap();
		data.putIfAbsent("id", "ssafy");
		data.putIfAbsent("password", "1234");
		data.putIfAbsent("name", "고윤하");
		return data;
	}

	// http://localhost:8080/mvc/rest1/test4
	// dto(객체) 반환 -> JSON 형태 (jackson)
	@ResponseBody
	@GetMapping("rest1/test4")
	public User test4() {
		User user = new User("ssafy", "1234", "고윤하");
		return user;
	}

	// http://localhost:8080/mvc/rest1/test5
	// list도 잘 반환 -> JSON 형태 (jackson)
	@ResponseBody
	@GetMapping("rest1/test5")
	public List<User> test5() {
		List<User> list = new ArrayList<>();
		list.add(new User("ssafy1", "486", "고윤하"));
		list.add(new User("ssafy2", "1234", "깐예"));
		list.add(new User("ssafy3", "1111", "타일러"));
		list.add(new User("ssafy4", "1231", "조휴일"));
		return list;
	}

}
