package com.rruimor.calculator.leastevenlydivisor.controllers;

import com.rruimor.calculator.leastevenlydivisor.domain.CalculationResult;
import com.rruimor.calculator.leastevenlydivisor.models.UpperRange;
import com.rruimor.calculator.leastevenlydivisor.services.LeastEvenlyDivisorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/least-evenly-divisor")
public class LeastEvenlyDivisorController {

    private static final Logger LOG = LoggerFactory.getLogger(LeastEvenlyDivisorController.class);
    private LeastEvenlyDivisorService leastEvenlyDivisorService;
    private UpperRange upperRange;

    public LeastEvenlyDivisorController(LeastEvenlyDivisorService leastEvenlyDivisorService, UpperRange upperRange) {
        this.leastEvenlyDivisorService = leastEvenlyDivisorService;
        this.upperRange = upperRange;
    }

    @GetMapping
    ResponseEntity getLeastEvenlyDivisor() {
        int upperNumber = this.upperRange.getValue();
        LOG.info("Starting calculation with upper range: {}", upperNumber);
        CalculationResult result = this.leastEvenlyDivisorService.findSmallestMultiple(upperNumber);
        LOG.info("Calculation result: {}", result);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("upper-range")
    ResponseEntity setRangeUpperNumber(@Valid @RequestBody UpperRange request) {
        LOG.info("Request with body {}", request);
        this.upperRange.setValue(request.getValue());
        LOG.info("Upper number set to {}", this.upperRange.getValue());
        return ResponseEntity.ok(null);
    }
}
