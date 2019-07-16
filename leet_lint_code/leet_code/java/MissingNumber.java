// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 268.
// Date: 2019.7.16

class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int n = nums.length + 1;
        int expect = n * (n - 1) / 2;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        
        return expect - sum;
    }
}