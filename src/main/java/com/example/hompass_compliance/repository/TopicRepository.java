package com.example.hompass_compliance.repository;

import com.example.hompass_compliance.entity.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TopicRepository extends CrudRepository<Topic, Long> {

    Optional<Topic> findAllById(Integer i);
}
