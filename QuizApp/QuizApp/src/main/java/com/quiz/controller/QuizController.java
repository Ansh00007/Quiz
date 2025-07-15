package com.quiz.controller;

import com.quiz.dto.AnswerRequest;
import com.quiz.dto.QuestionResponse;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/next")
    public ResponseEntity<QuestionResponse> getNextQuestion() {
        return ResponseEntity.ok(quizService.getNextQuestion());
    }

    @PostMapping("/answer")
    public ResponseEntity<Map<String, Object>> checkAnswer(@RequestBody AnswerRequest request) {
        boolean correct = quizService.checkAnswer(request.getQuestionId(), request.getSelectedOptionId());
        Map<String, Object> response = new HashMap<>();
        response.put("correct", correct);
        return ResponseEntity.ok(response);
    }
}
