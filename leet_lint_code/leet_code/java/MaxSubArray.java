// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 53.
// Date: 2019.7.15

class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
              
        int last = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; ++ i) {
            last = Math.max(0, last) + nums[i];
            ans = Math.max(ans, last);
        }
        
        return ans;
    }
}