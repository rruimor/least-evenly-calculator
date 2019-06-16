package com.rruimor.calculator.leastevenlydivisible.controllers;

import com.rruimor.calculator.leastevenlydivisible.domain.CalculationResult;
import com.rruimor.calculator.leastevenlydivisible.models.UpperRange;
import com.rruimor.calculator.leastevenlydivisible.services.LeastEvenlyDividableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping("/least-evenly-divisible")
public class LeastEvenlyDivisibleController {

    private static final Logger LOG = LoggerFactory.getLogger(LeastEvenlyDivisibleController.class);
    private LeastEvenlyDividableService leastEvenlyDividableService;
    private UpperRange upperRange;

    public LeastEvenlyDivisibleController(LeastEvenlyDividableService leastEvenlyDividableService, UpperRange upperRange) {
        this.leastEvenlyDividableService = leastEvenlyDividableService;
        this.upperRange = upperRange;
    }

    @GetMapping(produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    @ResponseBody
    CalculationResult getLeastEvenlyDivisor() {
        int upperNumber = this.upperRange.getValue();
        LOG.info("Starting calculation with upper range: {}", upperNumber);
        CalculationResult result = this.leastEvenlyDividableService.findSmallestMultiple(upperNumber);
        LOG.info("Calculation result: {}", result);
        return result;
    }

    @PostMapping("upper-range")
    ResponseEntity setRangeUpperNumber(@Valid @RequestBody UpperRange request) {
        LOG.info("Request with body {}", request);
        this.upperRange.setValue(request.getValue());
        LOG.info("Upper number set to {}", this.upperRange.getValue());
        return ResponseEntity.ok(null);
    }
}
