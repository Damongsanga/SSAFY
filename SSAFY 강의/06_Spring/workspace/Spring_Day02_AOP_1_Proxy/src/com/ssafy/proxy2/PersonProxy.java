package com.ssafy.proxy2;

import java.util.Random;

import com.ssafy.proxy.OuchException;

public class PersonProxy implements Person {

	private Person person;
	
	//필드주입
	//생성자주입
	//설정자주입
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public void coding() {
		System.out.println("컴퓨터를 부팅한다."); // 이전에 해야될것
		try {
			person.coding();
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
