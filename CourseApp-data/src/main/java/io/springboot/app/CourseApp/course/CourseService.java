package io.springboot.app.CourseApp.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses() {
		return courseRepository.getAllCourses();
	}

	public void addCourse(Course course, Integer topicId) {
		courseRepository.addCourse(course, topicId);
	}

	public void deleteCourse(String name) {
		courseRepository.deleteCourse(name);
	}

	public List<Course> getCourseByTopicId(Integer topicId) {
		return courseRepository.getAllCoursesByTopicId(topicId);
	}

	public void updateCourseName(String oldName, String newName) {
		courseRepository.updateCourseName(oldName, newName);
	}

	public void updateCourseDescription(String name, String description) {
		courseRepository.updateCourseDescription(name, description);
	}

}
