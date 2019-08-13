// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 202.
// Date: 2019.8.13

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class HappyNumber {
    public boolean isHappy(int n) {
        Map<Integer, Boolean> memo = new HashMap<>();
        Set<Integer> memo2 = new HashSet<>();
        memo.put(1, true);
        memo2.add(1);
        return isHappy(n, memo, memo2);
    }

    boolean isHappy(int n, Map<Integer, Boolean> memo, Set<Integer> memo2) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        memo2.add(n);
        int replace = 0;
        while (n > 0) {
            int digit = n % 10;
            replace += digit * digit;
            n = n / 10;
        }

        if (replace == 1) {
            memo.put(n, true);
            return true;
        }

        if (memo2.contains(replace) && !memo.containsKey(replace)) {
            return false;
        }

        return isHappy(replace, memo, memo2);
    }
}