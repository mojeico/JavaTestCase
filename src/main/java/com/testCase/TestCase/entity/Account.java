package com.testCase.TestCase.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accounts")
@NamedStoredProcedureQueries(
        @NamedStoredProcedureQuery(
        name = "sp_account_get",
        procedureName = "sp_account_get",
        resultClasses = { Account.class },
        parameters = {
                @StoredProcedureParameter(
                        name = "code",
                        type = String.class,
                        mode = ParameterMode.IN) })
)
public class Account implements Serializable {


    @Id
    @GeneratedValue
    public Long id;

    public String code;

    public String rest;

    public String currency;

    public String last_operation_date;


    public Account(String code, String rest, String currency, String last_operation_date) {
        this.code = code;
        this.rest = rest;
        this.currency = currency;
        this.last_operation_date = last_operation_date;
    }

    public Account(){}


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

    public String getLast_operation_date() {
        return last_operation_date;
    }

    public void setLast_operation_date(String last_operation_date) {
        this.last_operation_date = last_operation_date;
    }
}
