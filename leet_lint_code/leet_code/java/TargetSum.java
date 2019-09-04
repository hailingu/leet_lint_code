// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 494.
// Date: 2019.9.4


public class TargetSum {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int S) {
        int ans = 0;
        dfs(nums, S, 0, 0);
        return ans;
    }

    void dfs(int[] nums, int S, int i, int sum) {
      if (i == nums.length) {
          if (S == sum) {
              ++ ans;
          }
          return ;
      }

      dfs(nums, S, i + 1, sum + nums[i]);
      dfs(nums, S, i + 1, sum - nums[i]);
    }
}
