package com.nirmal.dsabean.controller;

import com.nirmal.dsabean.constants.ItemStatus;
import com.nirmal.dsabean.constants.Topic;
import com.nirmal.dsabean.dto.EnUserNameDto;
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

    @PostMapping("/save")
    public ResponseEntity addAllQuestion(@RequestBody List<QuestionDetailDto> questionDetailDtoList) {
        questionService.addAllQuestion(questionDetailDtoList);
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
    public ResponseEntity<List<EnUserNameDto>> getTopicList() {
        return new ResponseEntity<>(Topic.getList(), HttpStatus.OK);
    }

    @GetMapping("/allstatus")
    public ResponseEntity<List<EnUserNameDto>> getAllStatus() {
        return new ResponseEntity<>(ItemStatus.getList(), HttpStatus.OK);
    }
}
