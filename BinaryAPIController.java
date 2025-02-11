package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BinaryAPIController {

    @GetMapping("/add")
    public String add(@RequestParam String operand1, @RequestParam String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.add(number1, number2).getValue();
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam String operand1, @RequestParam String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.multiply(number1, number2).getValue();
    }

    @GetMapping("/and")
    public String and(@RequestParam String operand1, @RequestParam String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.and(number1, number2).getValue();
    }

    @GetMapping("/or")
    public String or(@RequestParam String operand1, @RequestParam String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.or(number1, number2).getValue();
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam String operand1, 
                            @RequestParam String operator, 
                            @RequestParam String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        Binary result;

        switch (operator) {
            case "+":
                result = Binary.add(number1, number2);
                break;
            case "*":
                result = Binary.multiply(number1, number2);
                break;
            case "&":
                result = Binary.and(number1, number2);
                break;
            case "|":
                result = Binary.or(number1, number2);
                break;
            default:
                return "Invalid operator";
        }

        return result.getValue();
    }
}

