package com.testCase.TestCase.repo;

import com.testCase.TestCase.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    @Override
    List<Account> findAll();
}
