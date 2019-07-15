// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 487.
// Date: 2019.7.15

class FindMaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int dp0 = 0;
        int dp1 = 0;
        int ans = -1;
        for (int i : nums) {
            if (i == 1) {
                dp0 = dp0 + 1;
                dp1 = dp1 + 1;
            } else {
                dp1 = dp0 + 1;
                dp0 = 0;
            }
            ans = Math.max(ans, dp1);
        }
        return ans;
    }
}