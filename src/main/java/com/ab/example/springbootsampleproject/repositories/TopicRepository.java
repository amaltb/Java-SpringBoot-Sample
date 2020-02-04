package com.ab.example.springbootsampleproject.repositories;

import com.ab.example.springbootsampleproject.models.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
