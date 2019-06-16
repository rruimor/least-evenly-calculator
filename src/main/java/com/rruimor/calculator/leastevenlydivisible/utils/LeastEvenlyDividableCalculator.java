package com.rruimor.calculator.leastevenlydivisible.utils;

import java.util.Collections;
import java.util.List;

import static com.rruimor.calculator.leastevenlydivisible.utils.ListCounter.getFrequency;

public final class LeastEvenlyDividableCalculator {

    private LeastEvenlyDividableCalculator() {}


    /**
     * @param upperRange Upper range number to be checked
     * @return the smallest number which is evenly divisible by all integers from 1 to {@code upperRange}
     */
    public static long findLeastEvenlyDividableForRange(int upperRange) {
        List<Integer> resultFactors = Collections.emptyList();

        for (int i = 1; i <= upperRange; i++) {
            List<Integer> newFactors = FactorsExtractor.extractFactors(i);
            resultFactors = mergeMaximumMultiplicityFactors(resultFactors, newFactors);
        }
        return resultFactors.stream().mapToLong(value -> value).reduce(1L, (subtotal, element) -> subtotal * element);
    }

    /**
     * @param existingFactors A list of factors
     * @param newFactors A list of factors to be merged based on multiplicity difference.
     * @return The {@code existingFactors} list of factors with potentially new factors added from the {@code newFactors}.
     *
     * It iterates by each of the factors in {@code newFactors} checking the maximum number of occurrences in both lists.
     * If the number of occurrences is greater in the {@code newFactors} list than in {@code existingFactors}, then the
     * factor is added x times to the {@code existingFactors} list, where x is the difference of the number of
     * occurrences of the factor between {@code newFactors} and {@code existingFactors}.
     */
    private static List<Integer> mergeMaximumMultiplicityFactors(List<Integer> existingFactors, List<Integer> newFactors) {
        if (existingFactors.isEmpty()) return newFactors;

        for (int i = 0; i < newFactors.size(); i++) {
            int factor = newFactors.get(i);

            if (i > 0 && factor == newFactors.get(i - 1)) {
                continue;
            }

            long countInNewFactors = getFrequency(newFactors, factor);
            long countInExistingFactors = getFrequency(existingFactors, factor);

            if (countInNewFactors > countInExistingFactors) {
                for (int j = 0; j < (countInNewFactors - countInExistingFactors); j++) {
                    existingFactors.add(factor);
                }
            }
        }
        existingFactors.sort(Integer::compareTo);
        return existingFactors;
    }
}
