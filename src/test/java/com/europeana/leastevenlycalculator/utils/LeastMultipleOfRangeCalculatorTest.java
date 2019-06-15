package com.europeana.leastevenlycalculator.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeastMultipleOfRangeCalculatorTest {

    @Test
    public void findSmallestMultiple() {
        assertEquals(2520, LeastMultipleOfRangeCalculator.findSmallestMultiple(10));
        assertEquals(360360, LeastMultipleOfRangeCalculator.findSmallestMultiple(15));
        assertEquals(26771144400L, LeastMultipleOfRangeCalculator.findSmallestMultiple(25));
    }
}
