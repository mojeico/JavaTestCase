package com.testCase.TestCase.controller;


import com.testCase.TestCase.entity.Score;
import com.testCase.TestCase.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @RequestMapping(value = "/getScore/{code}", method = RequestMethod.GET)
    public ResponseEntity<List<Score>> getScore(@PathVariable(name = "code") String code) {

        List<Score> scoreList = scoreService.findScore(code);


        return ResponseEntity.status(HttpStatus.OK).body(scoreList);
    }
}
