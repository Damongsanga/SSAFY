package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;

//공통관심사항들을 작성할 클래스를 생성한다.
public class MyAspect {
	//실행 이전
	public void before() {
		System.out.println("컴퓨터를 부팅한다.");
	}
	//실행 이후 (예외 없이)
	public void afterReturning() {
		System.out.println("Git에 Push 한다.");
	}
	
	//예외 발생 (서7김태운 / 대4박소현)
	public void afterThrowing(Throwable th) {
		System.out.println("반차를 낸다.");
		if(th instanceof OuchException) {
			((OuchException)th).handleException();
		}
	}
	
	public void after() {
		System.out.println("하루를 마무리 한다.");
	}
	
	////////////////////////////////////////////
	
	public void around(ProceedingJoinPoint pjt) {
		this.before();
		
		try {
			pjt.proceed();
			this.afterReturning();
		}catch (Throwable e) {
			this.afterThrowing(e);
		}finally {
			this.after();
		}
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
