package com.quiz.dto;

public class AnswerRequest {
    private Long questionId;
    private Long selectedOptionId;
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public Long getSelectedOptionId() {
		return selectedOptionId;
	}
	public void setSelectedOptionId(Long selectedOptionId) {
		this.selectedOptionId = selectedOptionId;
	}

    // Getters and Setters
    
}
