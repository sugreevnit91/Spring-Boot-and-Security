package io.springboot.app.CourseApp.aspect;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import io.springboot.app.CourseApp.course.Course;
import io.springboot.app.CourseApp.topics.Topic;

@Aspect
@Component
public class LoggingAspect {
	private Logger logger = LogManager.getLogger(getClass().getName());

	@Before("within(io.springboot.app.CourseApp..*)")
	public void loggingBefore(JoinPoint joinpoint) {
		logger.info("Inside "+joinpoint.getSignature().getName()+" of "+joinpoint.getTarget().getClass());
	}
	
	@AfterReturning(pointcut = "execution(* io.springboot.app.CourseApp.topics.TopicController.getAllTopics(..))", returning = "retVal")
	public void loggingAfterReturningTopic(JoinPoint joinPoint, Object retVal) {
		logger.info("Inside " + joinPoint.getSignature().getName() + " returning values: "
				+ ((List<Topic>) retVal).stream().map(topic -> topic.getName()).collect(Collectors.toList()));
	}
	
	@AfterReturning(pointcut = "execution(* io.springboot.app.CourseApp.course.CourseController.getAllCourses(..))", returning = "retVal")
	public void loggingAfterReturningCourse(JoinPoint joinPoint, Object retVal) {
		logger.info("Inside " + joinPoint.getSignature().getName() + " returning values: "
				+ ((List<Course>) retVal).stream().map(course -> course.getName()).collect(Collectors.toList()));
	}
	
	@AfterThrowing(pointcut = "execution(* io.springboot.app.CourseApp.topics.TopicController.*(..))", throwing = "ex")
	public void loggingAfterThrowingTopicExc(JoinPoint joinPoint, Exception ex) {
		logger.info("Inside " + joinPoint.getSignature().getName() + " throwing exception: ",ex);
	}
	
	@AfterThrowing(pointcut = "execution(* io.springboot.app.CourseApp.course.CourseController.*(..))", throwing = "ex")
	public void loggingAfterThrowingCourseExc(JoinPoint joinPoint, Exception ex) {
		logger.info("Inside " + joinPoint.getSignature().getName() + " throwing exception: ",ex);
	}
}
