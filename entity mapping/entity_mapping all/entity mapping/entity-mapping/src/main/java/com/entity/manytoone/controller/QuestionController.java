package com.entity.manytoone.controller;

import com.entity.manytoone.dao.AnswerRespository;
import com.entity.manytoone.dao.QuestionRepository;
import com.entity.manytoone.entity.Answer;
import com.entity.manytoone.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRespository answerRespository;

    @PostMapping("/questions")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {

        try {
            Question save = questionRepository.save(question);
            return new ResponseEntity<Question>(save, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Question>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getQuestions() {
        try {
            List<Question> questions = (List<Question>) questionRepository.findAll();
            if (!questions.isEmpty())
                return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
            else
                return new ResponseEntity<List<Question>>(questions, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Question>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<Optional<Question>> getQuestion(@PathVariable("questionId") int questionId) {
        try {
            Optional<Question> questions = questionRepository.findById(questionId);
            if (!questions.isEmpty())
                return new ResponseEntity<Optional<Question>>(questions, HttpStatus.OK);
            else
                return new ResponseEntity<Optional<Question>>(questions, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Optional<Question>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/questions/{questionId}")
    public ResponseEntity<Question> updateQuestion(@PathVariable("questionId") int questionId, @RequestBody Question question) {
        try {
            Optional<Question> questions = questionRepository.findById(questionId);
            Question qust;
            if (!questions.isEmpty()) {
                qust = questions.get();
                qust.setAnswers(question.getAnswers());
                Question save = questionRepository.save(qust);
                return new ResponseEntity<Question>(save, HttpStatus.OK);
            } else
                return new ResponseEntity<Question>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Question>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/questions/{questionId}/answer/{answerId}")
    public ResponseEntity<Question> updateQuestionAndAnswer(@PathVariable("questionId") int questionId, @PathVariable("answerId") int answerId) {
        try {
            Question question = questionRepository.findById(questionId).get();
            Answer answer = answerRespository.findById(answerId).get();
            Set<Answer> answers = question.getAnswers();
            answers.add(answer);
            question.setAnswers(answers);
            Question save = questionRepository.save(question);
            return new ResponseEntity<Question>(save, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Question>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/questions/{questionId}")
    public ResponseEntity<Question> deleteQuestion(@PathVariable("questionId") int questionId) {
        try {
            Optional<Question> questions = questionRepository.findById(questionId);
            Question qust;
            if (!questions.isEmpty()) {
                questionRepository.deleteById(questionId);
                return new ResponseEntity<Question>(HttpStatus.OK);
            } else
                return new ResponseEntity<Question>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Question>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
