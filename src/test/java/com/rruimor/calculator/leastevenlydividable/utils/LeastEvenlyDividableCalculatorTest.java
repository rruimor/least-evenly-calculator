package com.rruimor.calculator.leastevenlydividable.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeastEvenlyDividableCalculatorTest {

    @Test
    public void findLeastEvenlyDividableForRange() {
        assertEquals(2520, LeastEvenlyDividableCalculator.findLeastEvenlyDividableForRange(10));
        assertEquals(360360, LeastEvenlyDividableCalculator.findLeastEvenlyDividableForRange(15));
        assertEquals(26771144400L, LeastEvenlyDividableCalculator.findLeastEvenlyDividableForRange(25));
    }
}
