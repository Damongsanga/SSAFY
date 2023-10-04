package com.ssafy.di3;

public class Programmer {
	//프로그래머는 컴퓨터를 가지고 있어야된다~~
	private Computer computer;
	
	//생성자를 통해서 넣어주겠다. 
	//객체 생성 의존성 제거 더이상 new해서 만들지 않고 넣어줘
	public Programmer(Computer computer) {
//		computer = new Desktop();
		this.computer = computer;
	}
	
	//설정자(setter) 주입
	//필드 이름에 set을 붙이고 첫글자를 대문자로 바꾼 형태
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	
	
	
	public void coding() {
		System.out.println(computer.getInfo()+"으로 개발을 한다.");
	}
}
