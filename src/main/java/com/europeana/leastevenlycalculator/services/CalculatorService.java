package com.europeana.leastevenlycalculator.services;

import com.europeana.leastevenlycalculator.domain.CalculationResult;
import org.springframework.stereotype.Service;

@Service
public interface CalculatorService {
    CalculationResult findSmallestMultiple(int number);
}
