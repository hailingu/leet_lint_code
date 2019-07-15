// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 674.
// Date: 2019.7.15

class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int ans = 1;
        int i = 1;
        int j = 0;
        while (i < nums.length) {
            if (nums[i] > nums[i - 1]) {
                ++ i;
            } else {
                ans = Math.max(ans, i - j);
                j = i;
                ++ i;
            }
        }
        
        ans = Math.max(ans, i - j);
        return ans;
    }
}