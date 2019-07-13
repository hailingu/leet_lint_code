// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailingu
// This is a answer of leet code problem 26.
// Date: 2019.7.13

class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        
        int removedCnt = 0;
        int val = nums[0];
        for (int i = 1; i < nums.length; ++ i) {
            if (nums[i] == val) {
                removedCnt ++;
            } else {
                nums[i - removedCnt] = nums[i];
                val = nums[i];
            }
        }
        return nums.length - removedCnt;
    }
}