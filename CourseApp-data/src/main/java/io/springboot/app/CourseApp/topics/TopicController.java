package io.springboot.app.CourseApp.topics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/addTopic")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/updateTopicName")
	public void updateTopicName(@RequestParam String oldName, @RequestParam String newName) {
		topicService.updateTopicName(oldName, newName);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/updateTopicDescription")
	public void updateTopicDescription(@RequestParam String name, @RequestParam String newDescription) {
		topicService.updateTopicDescription(name, newDescription);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/deleteTopic/{id}")
	public void deleteTopic(@PathVariable String topicName) {
		topicService.deleteTopic(topicName);
	}
}