package com.nirmal.dsabean.dto;

import java.util.List;

public class QuestionDetailDto {
    private Long id;
    private List<String> topic;
    private Integer number;
    private String questionTitle;
    private String questionUrl;
    private String answerUrl;
    private String conceptUrl;
    private String hint;

    private List<AnswerDetailDto> answerDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getTopic() {
        return topic;
    }

    public void setTopic(List<String> topic) {
        this.topic = topic;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionUrl() {
        return questionUrl;
    }

    public void setQuestionUrl(String questionUrl) {
        this.questionUrl = questionUrl;
    }

    public String getAnswerUrl() {
        return answerUrl;
    }

    public void setAnswerUrl(String answerUrl) {
        this.answerUrl = answerUrl;
    }

    public String getConceptUrl() {
        return conceptUrl;
    }

    public void setConceptUrl(String conceptUrl) {
        this.conceptUrl = conceptUrl;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public List<AnswerDetailDto> getAnswerDetails() {
        return answerDetails;
    }

    public void setAnswerDetails(List<AnswerDetailDto> answerDetails) {
        this.answerDetails = answerDetails;
    }
}
