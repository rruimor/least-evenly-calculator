package com.europeana.leastevenlycalculator.utils;

import java.util.ArrayList;
import java.util.List;

final class FactorsExtractor {

    private FactorsExtractor() {}

    static List<Integer> extractFactors(int n) {
        List<Integer> factors = new ArrayList<>();

        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        int divisor = 3;
        while (n != 1) {
            while ((n % divisor) == 0) {
                factors.add(divisor);
                n /= divisor;
            }
            divisor += 2;
        }

        return factors;
    }
}
