package com.multicampus.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AroundAdvice {     
	
	@Around("PoincutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
		String method = jp.getSignature().getName();
		
		Object obj = null;
		long start = System.currentTimeMillis();
		
		obj = jp.proceed();
		
		long end = System.currentTimeMillis();
		System.out.println(method + "() 메소드 수행에 걸린 시간 : " + 
		(end - start) + "(ms)초");
		return obj;
	}
}
