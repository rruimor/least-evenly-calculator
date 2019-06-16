package com.rruimor.calculator.leastevenlydivisible.services;

import com.rruimor.calculator.leastevenlydivisible.domain.CalculationResult;
import com.rruimor.calculator.leastevenlydivisible.utils.LeastEvenlyDividableCalculator;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LeastEvenlyDividableServiceImpl implements LeastEvenlyDividableService {

    private static final double NANOSECONDS_TO_SECONDS = 1_000_000_000.0;

    @Override
    public CalculationResult findSmallestMultiple(int upperRangeValue) {
        long startTime = System.nanoTime();
        Long result = LeastEvenlyDividableCalculator.findLeastEvenlyDividableForRange(upperRangeValue);
        long durationInNanoSeconds = System.nanoTime() - startTime;
        BigDecimal durationInSeconds = BigDecimal.valueOf(durationInNanoSeconds / NANOSECONDS_TO_SECONDS);
        return new CalculationResult(result, durationInSeconds);
    }
}
