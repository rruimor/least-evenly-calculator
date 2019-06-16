package com.rruimor.calculator.leastevenlydivisor.services;

import com.rruimor.calculator.leastevenlydivisor.domain.CalculationResult;
import com.rruimor.calculator.leastevenlydivisor.utils.LeastMultipleOfRangeCalculator;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LeastEvenlyDivisorServiceImpl implements LeastEvenlyDivisorService {

    private static final double NANOSECONDS_TO_SECONDS = 1_000_000_000.0;

    @Override
    public CalculationResult findSmallestMultiple(int upperRangeValue) {
        long startTime = System.nanoTime();
        Long result = LeastMultipleOfRangeCalculator.findSmallestMultiple(upperRangeValue);
        long durationInNanoSeconds = System.nanoTime() - startTime;
        BigDecimal durationInSeconds = BigDecimal.valueOf(durationInNanoSeconds / NANOSECONDS_TO_SECONDS);
        return new CalculationResult(result, durationInSeconds);
    }
}
