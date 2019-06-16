package com.rruimor.calculator.leastevenlydividable.services;

import com.rruimor.calculator.leastevenlydividable.domain.CalculationResult;
import org.springframework.stereotype.Service;

@Service
public interface LeastEvenlyDividableService {
    CalculationResult findSmallestMultiple(int upperRangeValue);
}
