package com.europeana.leastevenlycalculator.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculationResult {
    private Long result;
    private Long timeElapsedInMilliseconds;

    @JsonCreator
    public CalculationResult(@JsonProperty("result") Long result,
                             @JsonProperty("timeElapsedInMilliseconds") Long timeElapsedInMilliseconds) {
        super();
        this.result = result;
        this.timeElapsedInMilliseconds = timeElapsedInMilliseconds;
    }

    public Long getResult() {
        return result;
    }

    public Long getTimeElapsedInMilliseconds() {
        return timeElapsedInMilliseconds;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    public void setTimeElapsedInMilliseconds(Long timeElapsedInMilliseconds) {
        this.timeElapsedInMilliseconds = timeElapsedInMilliseconds;
    }
}
