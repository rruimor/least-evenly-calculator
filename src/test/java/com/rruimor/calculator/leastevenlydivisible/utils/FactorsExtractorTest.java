package com.rruimor.calculator.leastevenlydivisible.utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FactorsExtractorTest {

    @Test
    public void extractFactors() {
        List<Integer> expectedFactors = Arrays.asList(2, 2, 5);
        assertEquals(expectedFactors, FactorsExtractor.extractFactors(20));
    }
}