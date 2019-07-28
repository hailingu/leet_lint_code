// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 457.
// Date: 2019.7.25

class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        
        Set<Integer> impossible = new HashSet<Integer>();
        Set<Integer> memo = new HashSet<Integer>();

        int i = 0, j = 0, last = -1;
        
        while (i < nums.length) {
            int sgn = nums[i] > 0 ? 1 : -1;
            memo.add(i);
            while (!impossible.contains(j)) {
                if (sgn * nums[j] <= 0 || last == j) {
                    impossible.addAll(memo);
                    break;
                } else {
                    memo.add(j);
                    last = j;
                    j += nums[j];
                    j %= nums.length;

                    if (j < 0) {
                        j += nums.length;
                    }
                    
                    if (memo.contains(j) && last != j) {
                        return true;
                    }
                    
                }
            }

            memo.clear();
            while (++i < nums.length && impossible.contains(i)) {} 
            j = i;
        }
        return false;
    }
}