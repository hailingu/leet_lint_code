// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 509.
// Date: 2019.8.19

import java.util.Map;
import java.util.HashMap;

class FibonacciNumber{
    public int fib(int N) {
        if (N == 0 || N == 1) {
            return N;
        } 
        
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 0);
        memo.put(1, 1);
        return fib(N, memo);
    }

    int fib(int N, Map<Integer, Integer> memo) {
        if (memo.containsKey(N)) {
            return memo.get(N);
        }

        memo.put(N, fib(N - 1, memo) + fib(N  - 2, memo));
        return memo.get(N);
    }
}