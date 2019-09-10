// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 1175.
// Date: 2019.9.10

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


class PrimeArrangements {
    long base = 1000000007;
    public int numPrimeArrangements(int n) {
        if (n <= 2) {
            return 1;
        }

        int[] primeArray = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        Set<Integer> primes = new HashSet<>();
        primes.addAll(Arrays.stream(primeArray).boxed().collect(Collectors.toList()));

        int primesCnt = 0;
        for (int i = 1; i <= n; ++i) {
            if (primes.contains(i)) {
                primesCnt++;
            }
        }

        int compositeCnt = n - primesCnt;
        long ans1 = arrangement(primesCnt);
        long ans2 = arrangement(compositeCnt);
        return (int)((ans1 * ans2) % base);
    }

    long arrangement(int n) {
        long ans = 1;
        long idx = 2;

        while (idx <= n) {
            ans = (ans * idx++) % base;
        }
        return ans;
    }
}