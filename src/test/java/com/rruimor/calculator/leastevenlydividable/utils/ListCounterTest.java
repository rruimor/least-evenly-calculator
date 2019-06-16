package com.rruimor.calculator.leastevenlydividable.utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ListCounterTest {

    @Test
    public void getFrequency() {
        List<Integer> testList = Arrays.asList(2, 3, 3);
        assertEquals(1, ListCounter.getFrequency(testList, 2));
        assertEquals(2, ListCounter.getFrequency(testList, 3));
        assertEquals(0, ListCounter.getFrequency(testList, 12));
    }
}