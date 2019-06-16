package com.rruimor.calculator.leastevenlydivisor.services;

import com.rruimor.calculator.leastevenlydivisor.domain.CalculationResult;
import org.springframework.stereotype.Service;

@Service
public interface LeastEvenlyDivisorService {
    CalculationResult findSmallestMultiple(int number);
}
