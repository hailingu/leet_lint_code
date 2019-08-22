// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 628.
// Date: 2019.8.23

class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        int ans = nums[l - 1] * nums[l - 2] * nums[l - 3];
      
        if (nums[0] > 0) {
          return ans;
        } else if (nums[0] < 0 && nums[1] < 0) {
          int ans2 = nums[0] * nums[1] * nums[l - 1];
          return Math.max(ans, ans2);
        } 
      
        return ans;
    }
}