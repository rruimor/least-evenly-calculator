package com.rruimor.calculator.leastevenlydivisible.services;

import com.rruimor.calculator.leastevenlydivisible.domain.CalculationResult;
import org.springframework.stereotype.Service;

@Service
public interface LeastEvenlyDividableService {
    CalculationResult findSmallestMultiple(int upperRangeValue);
}
