package com.example.calculator.model;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "results")

public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //The final result of the aritmetic operation
    private String result = null;
    //Message of the result (error message, or simply the result of fibonacci calculation)
    private String message = "";


    //If there is any error during the execution of the operation
    private Boolean error = Boolean.FALSE;

    //empty constructor
    public Result() {
    }

    public Result(String message, Boolean error, String result) {
        super();
        this.message = message;
        this.error = error;
        this.result = result;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the error
     */
    public Boolean getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(Boolean error) {
        this.error = error;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Result [message=" + message + ", error=" + error + ", result=" + result + "]";
    }

}

