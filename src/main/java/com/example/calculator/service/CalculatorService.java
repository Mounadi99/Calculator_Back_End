package com.example.calculator.service;

import com.example.calculator.controller.CalculatorController;
import com.example.calculator.model.Result;
import com.example.calculator.model.operations.OperationAbstract;
import com.example.calculator.model.operations.OperationInterface;
import com.example.calculator.repository.OperationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {
    private static final Logger logger = LogManager.getLogger(CalculatorController.class);

    @Autowired
    private OperationRepository repo;

    public Result saveResult(Result result) {

        return repo.save(result);
    }

    public List<Result> getAllResults() {
        List<Result> results = repo.findAll();
        return results;
    }

    public Result calculate(OperationAbstract operationAbstract){
        //the result object that is returned to the client
        Result result = new Result();

        //check if the operation is not null
        if (operationAbstract != null) {
            logger.info("Input data:" + operationAbstract.toString());
            result = doOperation(operationAbstract) ;
        } else {
            //if the operation is null return log it and return an message error to the client
            logger.error("Operation is null");
            result.setError(Boolean.TRUE);
            result.setMessage("Operation is not initializzed");
        }
        result = saveResult(result);
        return result;
    }
    /**
     * this method is responsible for executing the operation and catching error if there is one.
     * @param operation
     * @return Result object with the result of the operation
     */
    private Result doOperation(OperationInterface operation) {

        //The result object contain the result of the operation
        Result result = null;
        try {
            logger.info("Executing the operation.");
            //execute the operation with the run method
            result = operation.run();
        } catch (Exception ex) {
            //catch exceptions
            logger.error("Error during execution of doOperation method: ", ex);
            result.setError(Boolean.TRUE);
            result.setMessage("Ops! something wrong happened while executing doOperation!");
        }

        logger.info("Final operation result : " + result.toString());

        return result;

    }

}