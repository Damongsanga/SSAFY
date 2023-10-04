package com.ssafy.di2;

public class Programmer {
	//프로그래머는 컴퓨터를 가지고 있어야된다~~
	private Desktop computer;
	
	//생성자를 통해서 넣어주겠다. 
	//객체 생성 의존성 제거 더이상 new해서 만들지 않고 넣어줘
	public Programmer(Desktop computer) {
//		computer = new Desktop();
		this.computer = computer;
	}
	
	public void coding() {
		System.out.println(computer.getInfo()+"으로 개발을 한다.");
	}
}
