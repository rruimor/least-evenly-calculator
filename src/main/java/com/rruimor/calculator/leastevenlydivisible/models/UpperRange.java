package com.rruimor.calculator.leastevenlydivisible.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UpperRange {
    @NotNull
    @Max(25)
    @Min(1)
    private Integer value;

    @JsonCreator
    public UpperRange(@JsonProperty("value") Integer value) {
        super();
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UpperRange{" +
                "value=" + value +
                '}';
    }
}
