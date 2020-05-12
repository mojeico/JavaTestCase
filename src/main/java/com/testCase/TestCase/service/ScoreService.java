package com.testCase.TestCase.service;


import com.testCase.TestCase.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.*;

@Service
public class ScoreService {

    @Autowired
    private EntityManager manager;

    public List<Map<String, String>> findScore(String code) {

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

        return scores;
    }


}
