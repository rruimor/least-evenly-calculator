package com.europeana.leastevenlycalculator.controllers;

import com.europeana.leastevenlycalculator.domain.UpperRangeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UpperRangeController {

    private static final Logger LOG = LoggerFactory.getLogger(UpperRangeController.class);

    @PostMapping("/upper-number")
    ResponseEntity setRangeUpperNumber(@Valid @RequestBody UpperRangeRequest request) {
        if (request.getUpperNumber() == null) {
            return ResponseEntity.badRequest().body("upperNumber cannot be null");
        }

        LOG.info("Request with body {}", request);
        return ResponseEntity.ok(null);
    }

}
