package io.springboot.app.CourseApp.topics;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TopicRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Topic> getAllTopics() {
		List<Topic> topicList = jdbcTemplate.query("select id, name, description from topic",
				(ResultSet rs, int rowNum) -> {
					Topic topic = new Topic();
					topic.setId(rs.getInt(1));
					topic.setName(rs.getString(2));
					topic.setDescription(rs.getString(3));
					return topic;
				});
		return topicList;
	}

	public void addTopic(Topic topic) {
		insert("insert into topic (description, name) values (?, ?)",
				new Object[] { topic.getDescription(), topic.getName() });
	}

	public void updateTopicName(String oldName, String newName) {
		insert("update topic set name = ? where name = ?", new Object[] { newName, oldName });
	}

	public void updateTopicDescription(String name, String newDescription) {
		insert("update topic set description = ? where name = ?", new Object[] { newDescription, name });
	}

	public void deleteTopic(String topicName) {
		insert("delete from topic where name = ?", new Object[] { topicName });
	}
	
	private int insert(String sql, Object[] args) {
		return jdbcTemplate.update(con -> {
			final PreparedStatement ps = con.prepareStatement(sql);
			new ArgumentPreparedStatementSetter(args).setValues(ps);
			return ps;
		});
	}
	
}
