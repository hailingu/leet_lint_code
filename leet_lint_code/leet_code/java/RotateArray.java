// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 189.
// Date: 2019.8.22

class RotateArray {
    public void rotate(int[] nums, int k) {        
        int len = nums.length;
        
        if (len == 0 || len == 1 || k == 0) {
            return ;
        }
        
        k = k % len;
        int[] backUp = new int[len - k];
        
        int i = 0;
        while (i < backUp.length) {
            backUp[i] = nums[i ++];
        }
        
        int j = 0;
        while (i < nums.length) {
            nums[j ++] = nums[i ++];
        }
        
        i = 0;
        while (j < nums.length) {
            nums[j ++] = backUp[i ++];
        }
        
    }
}