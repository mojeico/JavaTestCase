package com.testCase.TestCase.controller;


import com.testCase.TestCase.repo.ScoreRepo;
import com.testCase.TestCase.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @Autowired
    ScoreRepo scoreRepo;

    @RequestMapping(value = "/getScore/{code}", method = RequestMethod.GET)
    public List<Map<String, String>> getScore(@PathVariable(name = "code") String code) {

        List<Map<String, String>> scoreList = scoreService.findScore(code);


        return scoreList;
    }
}
