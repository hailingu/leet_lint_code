// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 485.
// Date: 2019.7.15


class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = -1;
        int tmp = 0;
        for (int n : nums) {
            if (n == 1) {
                tmp ++;
            } else {
                max = max > tmp ? max : tmp;
                tmp = 0;
            }
        }
        
        max = max > tmp ? max : tmp;
        return max;
    }
}