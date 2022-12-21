package com.entity.manytoone.dao;

import com.entity.manytoone.entity.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
}
