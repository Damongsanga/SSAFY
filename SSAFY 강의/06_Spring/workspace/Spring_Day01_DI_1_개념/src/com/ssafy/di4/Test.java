package com.ssafy.di4;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Programmer p = new Programmer();
		
//		p.setComputer(ComputerFactory.getComputer("D"));
//		p.coding();
//		p.setComputer(ComputerFactory.getComputer("L"));
//		p.coding();
		
		
		while(true) {
			p.setComputer(ComputerFactory.getComputer(sc.next()));
			p.coding();
			
		}
		
	}
	
}
