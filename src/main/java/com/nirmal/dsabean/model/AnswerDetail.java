package com.nirmal.dsabean.model;

import javax.persistence.*;

@Entity
@Table
public class AnswerDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    String level;
    String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnswerDetail(String level, String url) {
        this.level = level;
        this.url = url;
    }

    public AnswerDetail() {

    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
