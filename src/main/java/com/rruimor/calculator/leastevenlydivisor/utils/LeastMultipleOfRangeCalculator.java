package com.rruimor.calculator.leastevenlydivisor.utils;

import java.util.Collections;
import java.util.List;

import static com.rruimor.calculator.leastevenlydivisor.utils.ListCounter.getFrequency;

public final class LeastMultipleOfRangeCalculator {

    private LeastMultipleOfRangeCalculator() {}

    public static long findSmallestMultiple(int upperRange) {
        List<Integer> resultFactors = Collections.emptyList();

        for (int i = 1; i <= upperRange; i++) {
            resultFactors = mergeMaximumMultiplicityFactors(resultFactors, FactorsExtractor.extractFactors(i));
        }
        return resultFactors.stream().mapToLong(value -> value).reduce(1L, (subtotal, element) -> subtotal * element);
    }

    private static List<Integer> mergeMaximumMultiplicityFactors(List<Integer> existingFactors, List<Integer> newFactors) {
        if (existingFactors.isEmpty()) return newFactors;

        for (int i = 0; i < newFactors.size(); i++) {
            int factor = newFactors.get(i);

            if (i > 0 && factor == newFactors.get(i - 1)) {
                continue;
            }

            long newCount = getFrequency(newFactors, factor);
            long oldCount = getFrequency(existingFactors, factor);

            if (newCount > oldCount) {
                for (int j = 0; j < (newCount - oldCount); j++) {
                    existingFactors.add(factor);
                }
            }
        }
        existingFactors.sort(Integer::compareTo);
        return existingFactors;
    }
}
