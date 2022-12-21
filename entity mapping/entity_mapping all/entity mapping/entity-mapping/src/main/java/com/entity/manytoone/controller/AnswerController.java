package com.entity.manytoone.controller;

import com.entity.manytoone.dao.AnswerRespository;
import com.entity.manytoone.entity.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AnswerController {
    @Autowired
    public AnswerRespository answerRespository;

    @DeleteMapping("/answer/{id}")
    public ResponseEntity<String> deleteAnswer(@PathVariable("id") int id) {
        try {
            answerRespository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/answer/{id}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable("id") int id, @RequestBody Answer answer) {
        try {
            Answer answerOld = answerRespository.findById(id).get();
            answer.setId(answerOld.getId());
            Answer save = answerRespository.save(answer);
            return new ResponseEntity<>(save, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/answer")
    public ResponseEntity<List<Answer>> getAnswers() {
        try {
            List<Answer> answers = (List<Answer>) answerRespository.findAll();
            if (!answers.isEmpty())
                return new ResponseEntity<>(answers, HttpStatus.OK);
            else
                return new ResponseEntity<>(answers, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("/answer/{id}")
    public ResponseEntity<Answer> getAnswer(@PathVariable("id") int id) {
        try {
            Optional<Answer> answers = answerRespository.findById(id);
            if (answers.isPresent())
                return new ResponseEntity<>(answers.get(), HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
