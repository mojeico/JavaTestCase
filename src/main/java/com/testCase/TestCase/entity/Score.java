package com.testCase.TestCase.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "scores")
@NamedStoredProcedureQueries(
        @NamedStoredProcedureQuery(
                name = "sp_account_get",
                procedureName = "sp_account_get",
                resultClasses = {Score.class},
                parameters = {
                        @StoredProcedureParameter(
                                name = "code",
                                type = String.class,
                                mode = ParameterMode.IN)})
)
public class Score implements Serializable {


    @Id
    @GeneratedValue
    public Long id;

    public String code;

    public String rest;

    public String currency;

    @Column(name = "last_operation_date")
    public LocalDateTime lastOperationDate;


    public Score(String code, String rest, String currency, LocalDateTime lastOperationDate) {
        this.code = code;
        this.rest = rest;
        this.currency = currency;
        this.lastOperationDate = lastOperationDate;
    }

    public Score() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRest() {
        return rest;
    }

    public void setRest(String rest) {
        this.rest = rest;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDateTime getLast_operation_date() {
        return lastOperationDate;
    }

    public void setLast_operation_date(LocalDateTime lastOperationDate) {
        this.lastOperationDate = lastOperationDate;
    }
}
