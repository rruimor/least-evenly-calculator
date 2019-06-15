package com.europeana.leastevenlycalculator.services;

import com.europeana.leastevenlycalculator.domain.CalculationResult;
import com.europeana.leastevenlycalculator.utils.LeastMultipleOfRangeCalculator;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public CalculationResult findSmallestMultiple(int number) {
        Instant start = Instant.now();
        Long result = LeastMultipleOfRangeCalculator.findSmallestMultiple(number);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        return new CalculationResult(result, timeElapsed.toMillis());
    }
}
