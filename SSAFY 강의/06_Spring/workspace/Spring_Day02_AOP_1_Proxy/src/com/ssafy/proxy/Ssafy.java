package com.ssafy.proxy;

import java.util.Random;

public class Ssafy {
	// 필드는 생략

	// 프로그래머의 일상
	public void coding() {
		System.out.println("컴퓨터를 부팅한다."); // 이전에 해야될것
		try {
			System.out.println("열심히 공부를 한다."); // 핵심관심사항
			if (new Random().nextBoolean())
				throw new OuchException();
			System.out.println("Git에 Push 한다."); // 이상없이 마무리가 되었을때.
		} catch (OuchException e) {
			System.out.println("반차를 낸다."); // 예외발생
		} finally {
			System.out.println("보람찬 하루를 마무리한다."); // 모든게 마무리가 되었을때.
		}
	}
}
