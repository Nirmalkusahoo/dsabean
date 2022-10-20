package com.nirmal.dsabean.service;

import com.nirmal.dsabean.dto.ProgramDetailDto;
import com.nirmal.dsabean.model.ProgramDetail;
import com.nirmal.dsabean.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class QuestionService {

    @Autowired
    ProgramRepository programRepository;
    @Autowired
    AuthService authService;

    public void addQuestion(ProgramDetailDto programDetailDto) {
        ProgramDetail programDetail = new ProgramDetail();
        programDetail.setQuestionTitle(programDetailDto.getQuestionTitle());
        programDetail.setQuestionUrl(programDetailDto.getQuestionUrl());
        programDetail.setAnswerUrl(programDetailDto.getAnswerUrl());
        programDetail.setConceptUrl(programDetailDto.getConceptUrl());
        programDetail.setHint(programDetailDto.getHint());
        User user = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("No user logged in"));

        programDetail.setUsername(user.getUsername());
        programDetail.setCreatedOn(Instant.now());
        programRepository.save(programDetail);
    }
}
