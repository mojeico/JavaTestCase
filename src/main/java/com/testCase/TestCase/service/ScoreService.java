package com.testCase.TestCase.service;


import com.testCase.TestCase.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private EntityManager manager;

    public List<Score> findScore(String code) {

        StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("sp_scores_get")
                .registerStoredProcedureParameter("code", String.class, ParameterMode.IN)
                .setParameter("code", code);


        return list;
    }


}
