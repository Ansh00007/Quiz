package com.quiz.service;

import com.quiz.dto.QuestionResponse;
import com.quiz.model.Question;
import com.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepo;

    public QuestionResponse getNextQuestion() {
        List<Question> all = questionRepo.findAll();
        if (all.isEmpty()) return null;

        Question q = all.get(new Random().nextInt(all.size()));
        QuestionResponse res = new QuestionResponse();
        res.setQuestionId(q.getId());
        res.setQuestionText(q.getText());
        res.setOptions(q.getOptions().stream().map(opt -> {
            QuestionResponse.OptionDTO dto = new QuestionResponse.OptionDTO();
            dto.setId(opt.getId());
            dto.setText(opt.getText());
            return dto;
        }).collect(Collectors.toList()));
        return res;
    }

    public boolean checkAnswer(Long questionId, Long selectedOptionId) {
        Optional<Question> question = questionRepo.findById(questionId);
        if (question.isEmpty()) return false;

        return question.get().getOptions().stream()
                .anyMatch(opt -> opt.getId().equals(selectedOptionId) && opt.isCorrect());
    }
}
