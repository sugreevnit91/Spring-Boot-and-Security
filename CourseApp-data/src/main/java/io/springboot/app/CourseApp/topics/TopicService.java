package io.springboot.app.CourseApp.topics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics() {
		return topicRepository.getAllTopics();
	}
	
	public void addTopic(Topic topic) {
		topicRepository.addTopic(topic);
	}

	public void updateTopicName(String oldName, String newName) {
		topicRepository.updateTopicName(oldName, newName);
	}

	public void updateTopicDescription(String name, String newDescription) {
		topicRepository.updateTopicDescription(name, newDescription);
	}
	
	public void deleteTopic(String topicName) {
		topicRepository.deleteTopic(topicName);
	}
}
