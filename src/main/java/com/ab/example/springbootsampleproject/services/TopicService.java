package com.ab.example.springbootsampleproject.services;

import com.ab.example.springbootsampleproject.models.Topic;
import com.ab.example.springbootsampleproject.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics()
    {
        return (List<Topic>) topicRepository.findAll();
    }

    public Topic getTopic(final String topicId)
    {
        return topicRepository.findById(topicId).get();
    }

    public Topic addTopic(final Topic topic)
    {
        return topicRepository.save(topic);
    }

    public Topic updateTopic(final String topicId, final Topic topic)
    {
        topic.setId(topicId);
        return topicRepository.save(topic);
    }

    public void deleteTopic(String topicId) {
        topicRepository.deleteById(topicId);
    }
}
