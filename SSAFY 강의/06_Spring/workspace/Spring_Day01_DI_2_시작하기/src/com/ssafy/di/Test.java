package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {

		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		Programmer p = (Programmer)context.getBean("programmer");
		
		Desktop desktop = context.getBean("desktop", Desktop.class);
		
//		p.setComputer(desktop);
//		
//		p.coding();
		
		Desktop d1 = context.getBean("desktop", Desktop.class);
		Desktop d2 = context.getBean("desktop", Desktop.class);
		
		System.out.println(d1==d2);
		
		
	}

}
