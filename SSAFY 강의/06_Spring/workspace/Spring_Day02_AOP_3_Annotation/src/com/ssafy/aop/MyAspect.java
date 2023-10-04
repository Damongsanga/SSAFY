package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
//공통관심사항들을 작성할 클래스를 생성한다.
public class MyAspect {
	
	@Pointcut("execution(public * com.ssafy.aop.*.coding())")
	public void mypt() {}
	
	
	//실행 이전
//	@Before("mypt()")
	public void before() {
		System.out.println("컴퓨터를 부팅한다.");
	}
	//실행 이후 (예외 없이)
//	@AfterReturning(value="mypt()", returning = "num")
	public void afterReturning(int num) {
		System.out.println("Git에 Push 한다."+num+"줄의 코드를");
	}
	
	//예외 발생 (서7김태운 / 대4박소현)
//	@AfterThrowing(value = "mypt()", throwing = "th")
	public void afterThrowing(Throwable th) {
		System.out.println("반차를 낸다.");
		if(th instanceof OuchException) {
			((OuchException)th).handleException();
		}
	}
	
//	@After("mypt()")
	public void after() {
		System.out.println("하루를 마무리 한다.");
	}
	
	////////////////////////////////////////////
	@Around("mypt()")
	public void around(ProceedingJoinPoint pjt) {
		this.before();
		
		try {
			int num = (Integer)pjt.proceed();
			this.afterReturning(num);
		}catch (Throwable e) {
			this.afterThrowing(e);
		}finally {
			this.after();
		}
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
