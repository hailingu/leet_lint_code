// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 283.
// Date: 2019.8.22


class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        
        int i = 0;
        int j = 0;
        
        while (i < nums.length) {
            while (i < nums.length && nums[i] != 0) { ++ i; }
            j = i + 1;
            while (j < nums.length && nums[j] == 0) { ++ j; }
            if (i < nums.length && j < nums.length) {
                nums[i] = nums[j];
                nums[j] = 0;
            }
            
            ++ i;
        }
        
        return ;
    }
}