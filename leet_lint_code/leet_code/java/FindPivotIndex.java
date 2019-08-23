// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 724.
// Date: 2019.8.23



class FindPivotIndex{
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        
        int ans = -1;
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        
        int left = 0;
        int right = sum - nums[0];
        for (int i = 0; i < nums.length - 1; ++ i) {
            if (left == right) {
                ans = i;
                return ans;
            }
            
            left += nums[i];
            right -= nums[i + 1];
        }
        
        if (left == right) {
            ans = nums.length - 1;
        }
        
        return ans;
    }
}