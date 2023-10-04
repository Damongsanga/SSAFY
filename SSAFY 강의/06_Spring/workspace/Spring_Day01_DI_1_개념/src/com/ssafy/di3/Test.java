package com.ssafy.di3;

public class Test {
	public static void main(String[] args) {
		
		Desktop computer = new Desktop();
		Laptop computer2 = new Laptop();
		Programmer p = new Programmer(computer2);
		p.coding();
		
		
		p.setComputer(computer);
		p.coding();
	}
	
}
