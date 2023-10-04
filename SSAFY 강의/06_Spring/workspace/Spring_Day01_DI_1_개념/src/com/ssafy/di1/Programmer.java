package com.ssafy.di1;

public class Programmer {
	//프로그래머는 컴퓨터를 가지고 있어야된다~~
	private Desktop computer;
	
	public Programmer() {
		computer = new Desktop();
	}
	
	public void coding() {
		System.out.println(computer.getInfo()+"으로 개발을 한다.");
	}
}
