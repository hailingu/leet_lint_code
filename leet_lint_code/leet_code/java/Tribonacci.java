// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 1137.
// Date: 2019.7.28

import java.util.Map;
import java.util.HashMap;

class Tribonacci {
    public int tribonacci(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return help(n, memo);
    }
    
    
    public int help(int n, Map<Integer, Integer> memo) {
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        if (n == 2) {
            return 1;
        }
        
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        int ans = help(n - 1, memo) + help(n - 2, memo) + help(n - 3, memo);
        memo.put(n, ans);
        return ans;
    }
}