package io.springboot.app.CourseApp.course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Course> getAllCourses() {
		List<Course> allCourses = jdbcTemplate.query("select id, description, name from course",
				(ResultSet rs, int rowNum) -> {
					Course course = new Course();
					course.setId(rs.getInt(1));
					course.setDescription(rs.getString(2));
					course.setName(rs.getString(3));
					return course;
				});
		return allCourses;
	}

	public List<Course> getAllCoursesByTopicId(Integer topicId) {
		List<Course> allCourses = jdbcTemplate.query("select id, description, name from course where topic_id = ?",
				new Object[] { topicId }, (ResultSet rs, int rowNum) -> {
					Course course = new Course();
					course.setId(rs.getInt(1));
					course.setDescription(rs.getString(2));
					course.setName(rs.getString(3));
					return course;
				});
		return allCourses;
	}

	public void addCourse(Course course, int topicId) {
		insert("insert into course (description, name, topic_id) value (?, ?, ?)",
				new Object[] { course.getDescription(), course.getName(), topicId });
	}

	public void updateCourseName(String oldName, String newName) {
		insert("update course set name = ? where name = ?", new Object[] { newName, oldName });
	}

	public void updateCourseDescription(String name, String description) {
		insert("update course set description = ? where name = ?", new Object[] { description, name });
	}

	public void deleteCourse(String name) {
		insert("delete from course where name = ?", new Object[] { name });
	}

	private int insert(String sql, Object[] args) {
		return jdbcTemplate.update(con -> {
			final PreparedStatement ps = con.prepareStatement(sql);
			new ArgumentPreparedStatementSetter(args).setValues(ps);
			return ps;
		});
	}
}
