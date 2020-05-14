package com.testCase.TestCase.service;


import com.testCase.TestCase.entity.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class ScoreService {

    private static final Logger logger = LoggerFactory.getLogger(ScoreService.class);
    @Autowired
    private EntityManager manager;

    public List<Map<String, String>> findScore(String code) {

        logger.info("Started findScore call for this code : {}", code);

        StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("sp_scores_get")
                .registerStoredProcedureParameter("code", String.class, ParameterMode.IN)
                .setParameter("code", code);

        List<Score> scoreList = storedProcedure.getResultList();

        List<Map<String, String>> scores = new LinkedList<>();

        for (Object score : scoreList) {
            scores
                    .add(
                            new LinkedHashMap<String, String>() {{
                                put("code", ((Object[]) score)[0].toString());
                                put("rest", ((Object[]) score)[1].toString());
                                put("currency", ((Object[]) score)[2].toString());
                            }}
                    );
        }


        logger.info("Completed findScore call for this code: {}", code);


        return scores;
    }


}
