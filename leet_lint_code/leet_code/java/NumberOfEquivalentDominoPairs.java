// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 1128.
// Date: 2019.8.13

class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int [] dominoe : dominoes) {
            int compose1 = 10 * dominoe[0] + dominoe[1];
            int compose2 = 10 * dominoe[1] + dominoe[0];
            int key = Math.max(compose1, compose2);
            
            if (memo.containsKey(key)) {
                int v = memo.get(key);
                ans += v;
                memo.put(key, v + 1);
            } 
            
            if (!memo.containsKey(key)) {
                memo.put(key, 1);
            }
        }
        
        return ans;
    }
}