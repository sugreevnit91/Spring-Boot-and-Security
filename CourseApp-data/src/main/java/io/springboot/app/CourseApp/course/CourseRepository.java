package io.springboot.app.CourseApp.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
	public List<Course> findByTopicId(String topicId);
}
