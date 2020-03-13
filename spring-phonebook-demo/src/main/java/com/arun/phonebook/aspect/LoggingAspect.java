package com.arun.phonebook.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.arun.phonebook.app.Contact;
import com.arun.phonebook.app.PhoneBookController;

@Aspect
@Component
public class LoggingAspect {

	Log logger = LogFactory.getLog(PhoneBookController.class);

	@Before("execution(* com.arun.phonebook.app.PhoneBookController.*(..))")
	public void loggingBefore(JoinPoint joinPoint) {
		logger.info("Inside " + joinPoint.getSignature().getName() + " method");
	}

	@AfterThrowing(pointcut = "execution(* com.arun.phonebook.app.PhoneBookController.*(..))", throwing = "ex")
	public void afterThrowLogging(Exception ex) throws Throwable {
		logger.error("Throwing exception is: " + ex);
	}

	@AfterReturning(pointcut = "execution(* com.arun.phonebook.app.PhoneBookController.getContactByName(..))", returning = "retVal")
	public void afterReturnByNameLogging(JoinPoint joinPoint, Object retVal) {
		logger.info("return value for the method " + joinPoint.getSignature().getName() + " is: "
				+ ((Contact) retVal).getName());
	}

	@AfterReturning(pointcut = "execution(* com.arun.phonebook.app.PhoneBookController.getContactByNumber(..))", returning = "retVal")
	public void afterReturnByNumberLogging(JoinPoint joinPoint, Object retVal) {
		logger.info("return value for the method " + joinPoint.getSignature().getName() + " is: "
				+ ((Contact) retVal).getMobNumber());
	}
	
	@Around("execution(* com.arun.phonebook.app.PhoneBookController.getAllContacts(..))")
    public void logAroundAllMethods(ProceedingJoinPoint joinPoint) throws Throwable 
    {
		logger.info("Inside " + joinPoint.getSignature().getName() + " Before Method Execution");
        try {
            joinPoint.proceed();
        } finally {
            //Do Something useful, If you have
        }
        logger.info(joinPoint.getSignature().getName() + " method is executed successfully");
    }
}
