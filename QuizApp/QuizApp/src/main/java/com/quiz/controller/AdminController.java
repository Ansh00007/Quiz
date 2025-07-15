package com.quiz.controller;

import com.quiz.model.Question;
import com.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private QuestionRepository questionRepo;

    @PostMapping("/question")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        question.getOptions().forEach(opt -> opt.setQuestion(question));
        questionRepo.save(question);
        return ResponseEntity.ok("Question added");
    }

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }
    @DeleteMapping("/question/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        questionRepo.deleteById(id);
        return ResponseEntity.ok("Question deleted");
    }

}
