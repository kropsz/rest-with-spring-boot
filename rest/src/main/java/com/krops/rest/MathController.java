package com.krops.rest;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.krops.rest.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

    // private static final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/{operation}/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double operations(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo,
                      @PathVariable(value = "operation") String operation)
            throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        switch(operation){
            case "sum":
            return converToDouble(numberOne) + converToDouble(numberTwo);

            case"sub":
            return converToDouble(numberOne) - converToDouble(numberTwo);

            case"multi":
            return converToDouble(numberOne) * converToDouble(numberTwo);
            
            case"div": 
            if(converToDouble(numberTwo) != 0){
                return converToDouble(numberOne) / converToDouble(numberTwo);
            }
            else{
                throw new ArithmeticException("Invalid division");
            }

            case"pot":
            return Math.pow(converToDouble(numberOne), converToDouble(numberTwo));

            case"mean":
            return converToDouble(numberOne) * converToDouble(numberTwo) / 2;

        }
        return 0D;
    }

     @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "number") String number)
            throws Exception {

        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return Math.sqrt(converToDouble(number));
    }


    private Double converToDouble(String strNumber) {
        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
        
    }
}