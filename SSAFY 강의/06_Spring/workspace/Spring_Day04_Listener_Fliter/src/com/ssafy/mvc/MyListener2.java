package com.ssafy.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener2 implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("웹 어플리케이션이 종료가 될 때 호출될 친구");
    }


    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("웹 어플리케이션이 시작될 때 호출될 친구");
    
    	ServletContext context = sce.getServletContext();
    	System.out.println(context.getInitParameter("welcome"));
    }
	
}
