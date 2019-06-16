package com.europeana.leastevenlycalculator.controllers;

import com.europeana.leastevenlycalculator.domain.CalculationResult;
import com.europeana.leastevenlycalculator.models.UpperRange;
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
    private CalculatorService calculatorService;
    private UpperRange upperRange;

    public CalculatorController(CalculatorService calculatorService, UpperRange upperRange) {
        this.calculatorService = calculatorService;
        this.upperRange = upperRange;
    }

    @GetMapping("/least-evenly-divisor")
    ResponseEntity getLeastEvenlyDivisor() {
        int upperNumber = this.upperRange.getValue();
        LOG.info("Starting calculation with upper range: {}", upperNumber);
        CalculationResult result = this.calculatorService.findSmallestMultiple(upperNumber);
        return ResponseEntity.ok().body(result);
    }
}
