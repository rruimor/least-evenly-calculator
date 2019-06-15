package com.europeana.leastevenlycalculator.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    /* returns smallest multiple that is evenly divisible by all numbers from 1 - n
     * returns -1 if multiple does not exist
     * works up to n = 20 (long reaches maximum value for values > 20) */
    public long findSmallestMultiple(int n) {
        for (long i = n; i <= factorial(n); i += n) {
            if (isMultiple(i, n)) return i;
        }
        return -1;
    }

    /* checks every number between 1 and n to see if x is a multiple of every number
     * returns true if x is found to be a multiple of every number, and false if x is
     * found to not be a multiple of any number */
    private boolean isMultiple(long x, int n) {
        for (int i = 1; i < n; i++) {
            if (x % i != 0) return false;
        }
        return true;
    }

    /* returns the n factorial, or -1 if it does not exist; works up to 20 */
    private long factorial(long n) {
        if (n > 1) return n * factorial(n - 1);
        else if (n >= 0) return 1;
        else return -1;
    }
}
