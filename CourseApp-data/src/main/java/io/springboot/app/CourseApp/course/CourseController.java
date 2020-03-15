package io.springboot.app.CourseApp.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/courses")
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getCourseByTopicId(@PathVariable Integer topicId) {
		return courseService.getCourseByTopicId(topicId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/courses/addCourse/topicId/{topicId}")
	public void addCourse(@PathVariable Integer topicId, @RequestBody Course course) {
		courseService.addCourse(course,topicId);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/courses/updateCourseName")
	public void updateCourseName(@RequestParam String oldName, @RequestParam String newName) {
		courseService.updateCourseName(oldName,newName);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/courses/updateCourseDescription")
	public void updateCourseDescription(@RequestParam String description, @RequestParam String name) {
		courseService.updateCourseDescription(name,description);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/deleteCourse/{id}")
	public void deleteCourse(@PathVariable String courseName) {
		courseService.deleteCourse(courseName);
	}
}