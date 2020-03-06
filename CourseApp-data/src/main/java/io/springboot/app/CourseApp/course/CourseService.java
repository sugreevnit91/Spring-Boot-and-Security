package io.springboot.app.CourseApp.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.app.CourseApp.topics.Topic;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId) {
		return courseRepository.findByTopicId(topicId);
	}
	
	public Course getCourseById(String id) {
		return courseRepository.findById(id).get();
	}

	public void addCourse(Course course, String topicId) {
		course.setTopic(new Topic(topicId));
		courseRepository.save(course);
	}

	public void updateCourse(Course course, String topicId) {
		course.setTopic(new Topic(topicId));
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}

}
