package com.nirmal.dsabean.repository;

import com.nirmal.dsabean.model.QuestionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionDetail, Long> {
    boolean existsByQuestionTitle(String questionTitle);
    List<QuestionDetail> findAllByTopic(String topic);
}
