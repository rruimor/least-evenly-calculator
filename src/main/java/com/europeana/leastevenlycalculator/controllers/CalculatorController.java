package com.europeana.leastevenlycalculator.controllers;

import com.europeana.leastevenlycalculator.services.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    private static final Logger LOG = LoggerFactory.getLogger(CalculatorController.class);

    @GetMapping("/least-evenly-divisor")
    ResponseEntity getLeastEvenlyDivisor() {
        LOG.info("Calculating least evenly divisor");
        Long result = this.calculatorService.findSmallestMultiple(20);
        return ResponseEntity.ok(result);
    }
}
