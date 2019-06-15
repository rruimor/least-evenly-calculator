package com.europeana.leastevenlycalculator.controllers;

import com.europeana.leastevenlycalculator.domain.UpperNumberRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/range")
public class RangeController {

    private static final Logger LOG = LoggerFactory.getLogger(RangeController.class);

    @PostMapping("/upper-number")
    ResponseEntity setRangeUpperNumber(@Valid @RequestBody UpperNumberRequest request) {
        LOG.info("Request with body {}", request);
        return ResponseEntity.ok(null);
    }

}
