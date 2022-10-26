package com.nirmal.dsabean.controller;

import com.nirmal.dsabean.dto.QuestionDetailDto;
import com.nirmal.dsabean.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionDetailController {

    @Autowired
    QuestionService questionService;

    @PostMapping
    public ResponseEntity addQuestion(@RequestBody QuestionDetailDto questionDetailDto) {
        questionService.addQuestion(questionDetailDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<QuestionDetailDto>> showAllQuestions(){
        return new ResponseEntity<> (questionService.showAllQuestions(),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<QuestionDetailDto> getSingleQuestion(@PathVariable @RequestBody Long id){
        return new ResponseEntity<> (questionService.readSingleQuestion(id),HttpStatus.OK);
    }
}
