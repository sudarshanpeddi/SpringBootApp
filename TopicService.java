package com.app.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.dto.Topic;

@Service
public class TopicService {
	
	List<Topic> topiclist = new ArrayList<Topic>(Arrays.asList(
			new Topic("one", "java", "twomonths"),
			new Topic("two", "C++", "twomonths"),
			new Topic("Three", "C", "twomonths"),
			new Topic("Four", "Python", "twomonths")
			));
	
	/*topiclist =Arrays.asList(
			new Topic(1, "java", "twomonths"),
			new Topic(2, "C++", "twomonths"),
			new Topic(3, "C", "twomonths"),
			new Topic(4, "Python", "twomonths")
			);*/
	
	public List<Topic> getAllTopics() {
		
		return  topiclist ;
	}
	
	public void addTopic(Topic topic) {
		
		topiclist.add(topic);
		System.out.println(topiclist);
	}

	public Topic getTopic(String id) {
		return topiclist.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void upateTopic(Topic topic, String id) {
		System.out.println("entered in servie");
		for(int i=0; i<topiclist.size();i++) {
			Topic top = topiclist.get(i);
			if(top.getId().equals(id))
				topiclist.set(i, topic);
				
		}
		System.out.println("completed service");
		
	}

	public void deleteTopic(String id) {
		topiclist.removeIf(t -> t.getId().equals(id));
		
	}

	/*public Topic getTopic(String id) {
		return topiclist.stream().filter( t -> t.getId().equals(id)).findFirst().get();
	}*/

}
