package com.example.hompass_compliance.repository;

import com.example.hompass_compliance.entity.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    @Override
    ArrayList<Question> findAll();

    @Override
    Optional<Question> findById(Long aLong);
}
