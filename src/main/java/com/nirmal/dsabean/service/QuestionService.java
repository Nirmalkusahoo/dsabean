package com.nirmal.dsabean.service;

import com.nirmal.dsabean.dto.QuestionDetailDto;
import com.nirmal.dsabean.exception.QuestionNotFoundException;
import com.nirmal.dsabean.model.QuestionDetail;
import com.nirmal.dsabean.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AuthService authService;

    public void addQuestion(QuestionDetailDto questionDetailDto) {
        QuestionDetail questionDetail = mapFromDtoToQuestionDetail(questionDetailDto);
        questionRepository.save(questionDetail);
    }

    private QuestionDetail mapFromDtoToQuestionDetail(QuestionDetailDto questionDetailDto) {
        QuestionDetail questionDetail = new QuestionDetail();
        questionDetail.setTopic(questionDetailDto.getTopic());
        questionDetail.setQuestionTitle(questionDetailDto.getQuestionTitle());
        questionDetail.setQuestionUrl(questionDetailDto.getQuestionUrl());
        questionDetail.setAnswerUrl(questionDetailDto.getAnswerUrl());
        questionDetail.setConceptUrl(questionDetailDto.getConceptUrl());
        questionDetail.setHint(questionDetailDto.getHint());
        User user = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("No user logged in"));

        questionDetail.setUsername(user.getUsername());
        questionDetail.setCreatedOn(Instant.now());
        return questionDetail;
    }

    public List<QuestionDetailDto> showAllQuestions() {
        List<QuestionDetail> list = questionRepository.findAll();
        return list.stream().map(this::mapToDto).collect(Collectors.toList());
    }
    public List<QuestionDetailDto> showAllQuestions(String topic) {
        List<QuestionDetail> list = questionRepository.findAllByTopic(topic);
        return list.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private QuestionDetailDto mapToDto(QuestionDetail questionDetail) {
        QuestionDetailDto dto = new QuestionDetailDto();
        dto.setTopic(questionDetail.getTopic());
        dto.setQuestionTitle(questionDetail.getQuestionTitle());
        dto.setQuestionUrl(questionDetail.getQuestionUrl());
        dto.setConceptUrl(questionDetail.getConceptUrl());
        dto.setAnswerUrl(questionDetail.getAnswerUrl());
        dto.setHint(questionDetail.getHint());
        return dto;
    }

    public QuestionDetailDto readSingleQuestion(Long id) {
        QuestionDetail questionDetail = questionRepository.findById(id).orElseThrow(() -> new QuestionNotFoundException("For id " + id));
        return mapToDto(questionDetail);
    }
}
