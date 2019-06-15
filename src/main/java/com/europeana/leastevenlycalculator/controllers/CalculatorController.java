package com.europeana.leastevenlycalculator.controllers;

import com.europeana.leastevenlycalculator.services.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private static final Logger LOG = LoggerFactory.getLogger(CalculatorController.class);

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/least-evenly-divisor")
    ResponseEntity getLeastEvenlyDivisor() {
        return ResponseEntity.ok().body(calculatorService.findSmallestMultiple(25));
    }
}
