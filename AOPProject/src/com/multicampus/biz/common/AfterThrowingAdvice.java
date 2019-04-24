package com.multicampus.biz.common;

import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	
	@AfterThrowing(pointcut="PoincutCommon.allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		System.out.println("[예외 처리] " + method + 
			"() 메소드 수행 중 예외 발생");
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("0번 글을 등록할 수 있나?");
		} else if(exceptObj instanceof ArithmeticException) {
			System.out.println("0으로 숫자를 나눌 수 있나?");
		} else if(exceptObj instanceof SQLException) {
			System.out.println("SQL 구문에 오류가 있네요.");
		} else {
			System.out.println("원인 모를 예외 발생!!!");
			exceptObj.printStackTrace();
		}
	}
}
