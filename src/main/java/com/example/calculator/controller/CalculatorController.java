package com.example.calculator.controller;

import java.util.List;

import com.example.calculator.model.operations.*;
import com.example.calculator.service.CalculatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.calculator.model.Result;
import com.example.calculator.model.operations.Addition;
import com.example.calculator.utils.Constants;

@RestController
@RequestMapping(Constants.CALCULATOR_PATH)
@CrossOrigin()
public class CalculatorController {

    private static final Logger logger = LogManager.getLogger(CalculatorController.class);
    @Autowired
    private CalculatorService service;

    /**
     * this method is responsible for addition operations only
     * @param addition
     * @return Result of the addition
     */

    @PostMapping("/add")
    public Result add(@RequestBody Addition addition) {
        //logging in the console the beginning of the subtract operation
        logger.info("Calling add operation!");
        return service.calculate(addition);
    }

    /**
     * this method is responsible for subtraction operations only
     *
     * @param substraction
     * @return Result of the operation
     */

    @PostMapping("/subtract")
    public Result subtract(@RequestBody Substraction substraction) {

        //logging in the console the beginning of the subtract operation
        logger.info("Calling substract operation!");
        return service.calculate(substraction);
    }

    /**
     * this method is responsible for multiplication operations only
     *
     * @param multiplication
     * @return Result of the operation
     */
    @PostMapping("/multiply")
    public Result multiply(@RequestBody Multiplication multiplication) {

        //logging in the console the beginning of the multipy operation
        logger.info("Calling multiply operation!");
        return service.calculate(multiplication);
    }

    /**
     * this method is responsible for division operations only
     *
     * @param division
     * @return Result of the operation
     */
    @PostMapping("/divide")
    public Result divide(@RequestBody Division division) {

        //logging in the console the beginning of the operation
        logger.info("Calling divide operation!");
        return service.calculate(division);
    }

    /**
     * this method is responsible for retrieving all results
     *
     * @return List of resuls
     */

    @GetMapping(value = "/Allresults")
    public List<Result> Allresults() {
        return service.getAllResults();
    }


}

