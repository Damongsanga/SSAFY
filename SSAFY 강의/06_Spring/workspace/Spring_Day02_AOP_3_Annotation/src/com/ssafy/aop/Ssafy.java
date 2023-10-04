package com.ssafy.aop;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Ssafy implements Person {
	// 필드는 생략

	// 프로그래머의 일상
	public Integer coding() {
		System.out.println("열심히 공부를 한다."); // 핵심관심사항
		if(new Random().nextBoolean()) {
			throw new OuchException();
		}
		return (int) (Math.random() * 100) + 1;
	}
}
