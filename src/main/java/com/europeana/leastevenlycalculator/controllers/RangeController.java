package com.europeana.leastevenlycalculator.controllers;

import com.europeana.leastevenlycalculator.models.UpperRange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/upper-range")
public class RangeController {

    private static final Logger LOG = LoggerFactory.getLogger(RangeController.class);
    private UpperRange upperRange;

    public RangeController(UpperRange upperRange) {
        this.upperRange = upperRange;
    }

    @PostMapping
    ResponseEntity setRangeUpperNumber(@Valid @RequestBody UpperRange request) {
        LOG.info("Request with body {}", request);
        this.upperRange.setValue(request.getValue());
        LOG.info("New upper number set to {}", this.upperRange.getValue());
        return ResponseEntity.ok(null);
    }
}
