package com.example.springPlayground;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/pi")
    public String getPi(){
        return "3.141592653589793";
    }

    @GetMapping("/calculate")
    public String mathCalculate(@RequestParam(defaultValue = "sum") String operation,
                                @RequestParam String x,
                                @RequestParam String y) {
        return MathService.calculate(operation,x,y);
    }

    @GetMapping("/sum")
    public String getSum(@RequestParam("n") List<String> n) {
        return MathService.sum(n);
    }

    @GetMapping("/volume/{x}/{y}/{z}")
    public String getVolume(@PathVariable String x, @PathVariable String y, @PathVariable String z) {
        return MathService.calculateVolume(x, y, z);
    }
}
