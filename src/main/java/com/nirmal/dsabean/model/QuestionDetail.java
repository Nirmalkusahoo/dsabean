package com.nirmal.dsabean.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table
public class QuestionDetail {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String topic;

    @Column
    private Integer number;

    @Id
    @Column
    private String questionTitle;

    @Column
    private String questionUrl;

    @Column
    private String answerUrl;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="answer_details")
    private List<AnswerDetail> answerDetails;

    @Column
    private String conceptUrl;

    @Lob
    @Column
    private String hint;

    @Column
    private String username;

    @Column
    private Instant createdOn;

    @Column
    private Instant updatedOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Instant updatedOn) {
        this.updatedOn = updatedOn;
    }

    public List<AnswerDetail> getAnswerDetails() {
        return answerDetails;
    }

    public void setAnswerDetails(List<AnswerDetail> answerDetails) {
        this.answerDetails = answerDetails;
    }
}
