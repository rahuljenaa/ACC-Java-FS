
package com.accenture.ltt.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	// Define a named pointcut for repository methods
	@Pointcut("execution(* com.accenture.ltt.repository.EmployeeRepository.*(..))")
	private void repositoryMethods() {
		// Pointcut signature — no implementation needed
		System.out.println("Pointcut for repository methods defined.");
	}

	// Use the named pointcut in the advice
	@Around("repositoryMethods()")
	public Object logRepositoryMethods(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("Entering repository method: {} with args {}", pjp.getSignature(), pjp.getArgs());
		Object result = pjp.proceed();
		logger.info("Exiting repository method: {} with result {}", pjp.getSignature(), result);
		return result;
	}
}
