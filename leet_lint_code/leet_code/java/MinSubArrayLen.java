// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 209.
// Date: 2019.7.24

public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        // Map<Integer, Integer> map = new HashMap<>();

        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;
        int i = 0;

        while (i < nums.length && j <= i) {
            sum += nums[i];

            if (sum < s) {
                ++ i;
            } else {
                while (sum >= s) {
                    ans = Math.min(ans, i - j + 1);
                    sum -= nums[j];
                    ++ j;
                }
                ++ i;
            }
        }

        if (ans == Integer.MAX_VALUE) {
            return 0;
        }
        return ans;
    }
}