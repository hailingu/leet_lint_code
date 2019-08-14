// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 136.
// Date: 2019.8.14

class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; ++ i) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}