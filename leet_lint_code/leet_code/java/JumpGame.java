// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 55.
// Date: 2019.9.12

public class JumpGame {
    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        memo[nums.length - 1] = 1;
        return dfs(nums, 0, memo);
    }

    boolean dfs(int[] nums, int i, int[] memo) {
        if (i >= (nums.length - 1)) {
            return true;
        }

        if (memo[i] == 1) {
            return true;
        } else if (memo[i] == -1) {
            return false;
        }

        for (int q = nums[i]; q >= 1 ; -- q) {
            if (dfs(nums, i + q, memo)) {
                memo[i] = 1;
                return true;
            }
        }

        memo[i] = -1;
        return false;
    }
}
