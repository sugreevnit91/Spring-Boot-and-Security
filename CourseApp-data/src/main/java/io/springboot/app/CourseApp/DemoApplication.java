package io.springboot.app.CourseApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import io.springboot.app.CourseApp.course.Course;
import io.springboot.app.CourseApp.course.CourseController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		CourseController courseController = context.getBean(CourseController.class);
		Course course = new Course();
		course.setName("Core Java");
		course.setDescription("Core Java Description");
		courseController.addCourse(4, course);
	}

}
