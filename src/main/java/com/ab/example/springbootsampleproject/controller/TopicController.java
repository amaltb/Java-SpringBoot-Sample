package com.ab.example.springbootsampleproject.controller;

import com.ab.example.springbootsampleproject.models.Topic;
import com.ab.example.springbootsampleproject.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(path = "/topics", method = RequestMethod.GET)
    public List<Topic> getAllTopics()
    {
        return topicService.getAllTopics();
    }

    @RequestMapping(path = "/topics/{id}", method = RequestMethod.GET)
    public Topic getTopic(@PathVariable("id") final String topicId)
    {
        return topicService.getTopic(topicId);
    }

    @RequestMapping(path = "/topics", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Topic createTopic(@RequestBody Topic topic){
        return topicService.addTopic(topic);
    }

    @RequestMapping(path = "/topics/{id}", method = RequestMethod.PUT)
    public Topic updateTopic(@RequestBody Topic topic, @PathVariable("id") final String topicId)
    {
        return topicService.updateTopic(topicId, topic);
    }

    @RequestMapping(path = "/topics/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTopic(@PathVariable("id") final String topicId)
    {
        topicService.deleteTopic(topicId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
