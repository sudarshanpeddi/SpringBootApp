package com.app.topic;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Topic;

@RestController
@RequestMapping(value="/topics")
public class TopicController {
	
	@Autowired
	TopicService topicservice;
	
	@RequestMapping(value="/gettopics")
	public List<Topic> getAllTopics() {
		return topicservice.getAllTopics();
	}
	
	
    @RequestMapping(value="/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicservice.getTopic(id);
		
	}
	@RequestMapping(method = RequestMethod.POST, value="/addtopic")
	public void addTopic(@RequestBody Topic topic) {
		
		topicservice.addTopic(topic);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
	public void updateTopic( @RequestBody Topic topic, @PathVariable String id) {
		System.out.println("enterd controler");
		
		topicservice.upateTopic(topic, id);
		
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicservice.deleteTopic(id);
		
	}
}
