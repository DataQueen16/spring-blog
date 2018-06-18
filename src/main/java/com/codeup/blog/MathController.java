package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    public @ResponseBody String addition(@PathVariable int num1, @PathVariable int num2) {
        String answer = num1 + " + " + num2 + " = " + (num1 + num2);
        return answer;
    }

    @GetMapping("/subtract/{var1}/and/{var2}")
    public @ResponseBody String subtraction(
            @PathVariable double var1, @PathVariable double var2) {
        String result = var1 + " - " + var2 + " = " + (var1-var2);
        return result;
    }

    @GetMapping("/multiply/{num1}/times/{num2}")
    public @ResponseBody String multiply(
            @PathVariable int num1, @PathVariable int num2) {
        String result = num1 + " * " + num2 + " = " + (num1 * num2);
        return result;
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    public @ResponseBody String divide(@PathVariable int num1, @PathVariable int num2) {
        String result = num1 + " / " + num2 + " = " + (num1/num2);
        return result;
    }
}
