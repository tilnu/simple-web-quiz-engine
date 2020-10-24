package com.github.tilnu.webquizengine.controller;

import com.github.tilnu.webquizengine.model.Answer;
import com.github.tilnu.webquizengine.model.Feedback;
import com.github.tilnu.webquizengine.model.Quiz;
import com.github.tilnu.webquizengine.repository.QuizRepository;
import com.github.tilnu.webquizengine.service.FeedbackBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api")
public class QuizController {

    @Autowired
    private QuizRepository quizRepository;

    @PostMapping(value = "/quizzes", consumes = "application/json")
    public Quiz CreateQuiz(@Valid @RequestBody Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @PostMapping("/quizzes/{id}/solve")
    public ResponseEntity<Feedback> Solve(@PathVariable long id, @RequestBody Answer answer)
            throws RuntimeException {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
        if ((answer.getAnswer().length == 0 && quiz.getAnswer() == null) ||
                Arrays.equals(quiz.getAnswer(), answer.getAnswer())) {
            return ResponseEntity.ok().body(FeedbackBuilder.rightAnswer());
        }
        return ResponseEntity.ok().body(FeedbackBuilder.wrongAnswer());
    }

    @GetMapping("/quizzes")
    public List<Quiz> GetAllQuizzes() {
        return quizRepository.findAll();
    }

    @GetMapping("/quizzes/{id}")
    public ResponseEntity<Quiz> GetQuiz(@PathVariable long id) throws RuntimeException {
            Quiz quiz = quizRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
            return ResponseEntity.ok().body(quiz);
    }

}
