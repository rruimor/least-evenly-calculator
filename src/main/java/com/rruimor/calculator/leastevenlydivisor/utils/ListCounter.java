package com.rruimor.calculator.leastevenlydivisor.utils;

import java.util.List;

final class ListCounter {

    private ListCounter() {}

    static long getFrequency(List<Integer> list, Integer element) {
        return list.stream().filter(integer -> integer.equals(element)).count();
    }
}
