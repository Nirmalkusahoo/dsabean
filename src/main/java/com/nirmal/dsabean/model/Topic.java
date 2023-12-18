package com.nirmal.dsabean.model;

import javax.persistence.*;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String topicName;

    @ManyToOne
    @JoinColumn(name = "question_detail.question_title")
    private QuestionDetail questionDetail;

    public Topic(String topicName) {
        this.topicName = topicName;
    }

    public Topic() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionDetail getQuestionDetail() {
        return questionDetail;
    }

    public void setQuestionDetail(QuestionDetail questionDetail) {
        this.questionDetail = questionDetail;
    }

    public String getTopicName() {
        return topicName;
    }


    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
