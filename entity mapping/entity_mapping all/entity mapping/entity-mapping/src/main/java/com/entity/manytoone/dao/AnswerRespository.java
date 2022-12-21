package com.entity.manytoone.dao;

import com.entity.manytoone.entity.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRespository extends CrudRepository<Answer, Integer> {
}
