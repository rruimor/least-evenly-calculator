package com.europeana.leastevenlycalculator.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UpperNumberRequest {
    @NotNull
    @Max(25)
    @Min(1)
    private Integer upperNumber;

    @JsonCreator
    public UpperNumberRequest(@JsonProperty("upperNumber") Integer upperNumber) {
        super();
        this.upperNumber = upperNumber;
    }

    public Integer getUpperNumber() {
        return upperNumber;
    }
}
