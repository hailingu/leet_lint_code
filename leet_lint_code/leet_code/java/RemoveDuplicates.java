// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailingu
// This is a answer of leet code problem 26.
// Date: 2019.7.13

class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = i + 1;
        
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++ i] = nums[j ++];
            } else {
                ++ j;
            }
        }
        
        return i + 1;
    }
}