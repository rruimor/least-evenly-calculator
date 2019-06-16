package com.rruimor.calculator.leastevenlydivisor.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class CalculationResult {
    private long result;
    private BigDecimal timeElapsedInSeconds;

    @JsonCreator
    public CalculationResult(@JsonProperty("result") Long result,
                             @JsonProperty("timeElapsedInSeconds") BigDecimal timeElapsedInSeconds) {
        super();
        this.result = result;
        this.timeElapsedInSeconds = timeElapsedInSeconds;
    }

    public long getResult() {
        return result;
    }

    public BigDecimal getTimeElapsedInSeconds() {
        return timeElapsedInSeconds;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    public void setTimeElapsedInSeconds(BigDecimal timeElapsedInSeconds) {
        this.timeElapsedInSeconds = timeElapsedInSeconds;
    }
}
