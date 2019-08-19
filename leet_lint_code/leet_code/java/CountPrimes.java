// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 204.
// Date: 2019.8.19

import java.util.List;
import java.util.ArrayList;


class CountPrimes {
    public int countPrimes(int n) {        
        if (n <= 2) {
            return 0;
        }
        
        List<Integer> memo = new ArrayList<>();
        if (n % 2 == 0) {
            n = n + 1;
        }
        

        int ans = 1;
        for (int i = 1; i < n; i += 2) {
            if (isPrime(i, memo)) ++ ans;
        }
        return ans;
    }
    
    boolean isPrime(int num, List<Integer> memo) {
        if (num <= 1) return false;
        int j = 2;
        for (int i = 0; i < memo.size() && j * j < num; ++ i) {
            j = memo.get(i);
            if (num % j == 0) return false;
        }
        
        memo.add(num);
        return true;
    }
}