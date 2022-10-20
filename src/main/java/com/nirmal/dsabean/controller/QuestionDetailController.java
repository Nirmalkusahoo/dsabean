package com.nirmal.dsabean.controller;

import com.nirmal.dsabean.dto.ProgramDetailDto;
import com.nirmal.dsabean.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/questions")
public class QuestionDetailController {

    @Autowired
    QuestionService questionService;

    public ResponseEntity addQuestion(@RequestBody ProgramDetailDto programDetailDto) {
        questionService.addQuestion(programDetailDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
