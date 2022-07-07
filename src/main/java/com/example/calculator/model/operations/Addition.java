
package com.example.calculator.model.operations;


import com.example.calculator.model.Result;
import com.example.calculator.utils.Constants;

public class Addition extends OperationAbstract {

    @Override
    public Result run() {
        Result result = new Result();

        if (this.operand1 != null && this.operand2 != null) {
            result.setResult(operand1+ " + " + operand2 + " = " + operand1.add(operand2));
            result.setError(Boolean.FALSE);
        } else {
            result.setError(Boolean.TRUE);
            result.setMessage(Constants.ERROR_MESSAGE_OPERAND_NOT_VALID);
            getLogger().error("One of the operands is not valid" + this.toString());
        }

        return result;
    }

    @Override
    public String toString() {
        return "AddOperation [operand1=" + operand1 + ", operand2=" + operand2 + "]";
    }
}

