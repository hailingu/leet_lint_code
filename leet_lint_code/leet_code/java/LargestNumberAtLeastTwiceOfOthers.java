// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 747.
// Date: 2019.8.23

import java.util.Arrays;

class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        
        if (nums.length == 1) {
            return 0;
        }
        
        int[] back = Arrays.copyOf(nums, nums.length);
        Arrays.sort(back);
        
        if (back[back.length - 2] != 0 && back[back.length - 1] / back[back.length - 2] < 2) {
            return -1;
        }
        
        for (int i = 0; i < nums.length; ++ i) {
            if (nums[i] == back[back.length - 1]) {
                return i;
            }
        }
        return -1;
    }
}