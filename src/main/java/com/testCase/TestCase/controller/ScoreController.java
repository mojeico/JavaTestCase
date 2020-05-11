package com.testCase.TestCase.controller;


import com.testCase.TestCase.entity.Account;
import com.testCase.TestCase.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.List;

@RestController
public class ScoreController {

    @Autowired
    AccountRepo accountRepo;


    @PersistenceContext
    private EntityManager manager;

    @RequestMapping(value = "/get/{code}", method = RequestMethod.GET)
    public List<Account> getScore(@PathVariable(name = "code" ) String code){






        StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("sp_account_get")
                .registerStoredProcedureParameter(0 , String.class , ParameterMode.IN);

        storedProcedure.setParameter(0, code);


        List<Account> list = storedProcedure.getResultList();



        return list;
    }
}
