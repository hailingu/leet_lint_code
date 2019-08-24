// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 643 .
// Date: 2019.8.23


class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
      
        int c = 0;
        double ans = Integer.MIN_VALUE;
        double sum = 0;
        for (int i = 0; i < nums.length; ++ i) {
          if (c < k) {
            sum += nums[i];
            ++ c;
          }
          
          if (c == k) {
            ans = Math.max(ans, sum / k);
            --c; 
            sum -= nums[i - k + 1];
          }
        }
          
        return ans;
    }
}