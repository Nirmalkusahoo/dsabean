package com.nirmal.dsabean.service;

import com.nirmal.dsabean.dto.AnswerDetailDto;
import com.nirmal.dsabean.dto.QuestionDetailDto;
import com.nirmal.dsabean.model.AnswerDetail;
import com.nirmal.dsabean.model.QuestionDetail;
import com.nirmal.dsabean.model.Topic;
import com.nirmal.dsabean.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
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

    public void addAllQuestion(List<QuestionDetailDto> dtoList) {
        List<QuestionDetail> list = new ArrayList<>();
        for (QuestionDetailDto dto : dtoList) {
            list.add(mapFromDtoToQuestionDetail(dto));
        }
        questionRepository.saveAll(list);
    }

    private QuestionDetail mapFromDtoToQuestionDetail(QuestionDetailDto questionDetailDto) {
        QuestionDetail questionDetail = new QuestionDetail();

        questionDetail.setNumber(questionDetailDto.getNumber());
        questionDetail.setQuestionTitle(questionDetailDto.getQuestionTitle());
        questionDetail.setQuestionUrl(questionDetailDto.getQuestionUrl());
        questionDetail.setAnswerUrl(questionDetailDto.getAnswerUrl());
        questionDetail.setConceptUrl(questionDetailDto.getConceptUrl());
        questionDetail.setHint(questionDetailDto.getHint());
        User user = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("No user logged in"));

        questionDetail.setUsername(user.getUsername());
        questionDetail.setCreatedOn(Instant.now());

        setAnswerDetails(questionDetailDto, questionDetail);
        setTopic(questionDetailDto.getTopic(), questionDetail);
        return questionDetail;
    }

    private AnswerDetail mapFromDtoToAnswerDetail(AnswerDetailDto answerDetailDto) {
        AnswerDetail answerDetail = new AnswerDetail();
        answerDetail.setLevel(answerDetailDto.getLevel());
        answerDetail.setUrl(answerDetailDto.getUrl());
        return answerDetail;
    }

    private void setAnswerDetails(QuestionDetailDto questionDetailDto, QuestionDetail questionDetail) {
        if (null == questionDetailDto.getAnswerDetails()) return;
        List<AnswerDetail> answerList = new ArrayList<>();
        for (AnswerDetailDto obj : questionDetailDto.getAnswerDetails()) {
            answerList.add(mapFromDtoToAnswerDetail(obj));
        }
        questionDetail.setAnswerDetails(answerList);
    }

    private void setTopic(List<String> topics, QuestionDetail questionDetail) {
        List<Topic> list = new ArrayList<>();
        for (String topic : topics) {
            list.add(new Topic(topic));
        }
        questionDetail.setTopic(list);
    }

    public List<QuestionDetailDto> showAllQuestions() {
        List<QuestionDetail> list = questionRepository.findAll();
        return list.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public List<QuestionDetailDto> showAllQuestions(String topic) {
        List<QuestionDetail> list = questionRepository.findByTopicTopicName(topic);
        return list.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private QuestionDetailDto mapToDto(QuestionDetail questionDetail) {
        QuestionDetailDto dto = new QuestionDetailDto();
        dto.setQuestionTitle(questionDetail.getQuestionTitle());
        dto.setNumber(questionDetail.getNumber());
        dto.setQuestionUrl(questionDetail.getQuestionUrl());
        dto.setConceptUrl(questionDetail.getConceptUrl());
        dto.setAnswerUrl(questionDetail.getAnswerUrl());
        dto.setHint(questionDetail.getHint());

        List<AnswerDetailDto> answerList = new ArrayList<>();
        for (AnswerDetail obj : questionDetail.getAnswerDetails()) {
            answerList.add(mapToAnswerDto(obj));
        }
        dto.setAnswerDetails(answerList);
        setTopicToDto(questionDetail.getTopic(), dto);
        return dto;
    }

    private AnswerDetailDto mapToAnswerDto(AnswerDetail answerDetail) {
        AnswerDetailDto answerDetailDto = new AnswerDetailDto();
        answerDetailDto.setLevel(answerDetail.getLevel());
        answerDetailDto.setUrl(answerDetail.getUrl());
        return answerDetailDto;
    }

    private void setTopicToDto(List<Topic> topicList, QuestionDetailDto dto) {
        List<String> list = new ArrayList<>();
        for (Topic topic : topicList) list.add(topic.getTopicName());
        dto.setTopic(list);
    }

    public QuestionDetailDto readSingleQuestion(Integer number) {
        QuestionDetail questionDetail = questionRepository.findByNumber(number);
        return mapToDto(questionDetail);
    }
}
