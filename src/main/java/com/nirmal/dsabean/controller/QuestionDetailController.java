package com.nirmal.dsabean.controller;

import com.nirmal.dsabean.constants.Topic;
import com.nirmal.dsabean.dto.QuestionDetailDto;
import com.nirmal.dsabean.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<QuestionDetailDto>> showAllQuestions() {
        return new ResponseEntity<>(questionService.showAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("all/{topic}")
    public ResponseEntity<List<QuestionDetailDto>> showAllQuestions(@PathVariable @RequestBody String topic) {
        return new ResponseEntity<>(questionService.showAllQuestions(topic), HttpStatus.OK);
    }

    @GetMapping("/{number}")
    public ResponseEntity<QuestionDetailDto> getSingleQuestion(@PathVariable @RequestBody Integer number) {
        return new ResponseEntity<>(questionService.readSingleQuestion(number), HttpStatus.OK);
    }

    @GetMapping("/topics")
    public ResponseEntity<List<String>> getTopicList() {
        List<String> topicList = Arrays.stream(Topic.values()).map(Topic::getTopic).collect(Collectors.toList());
        return new ResponseEntity<>(topicList, HttpStatus.OK);
    }
}
