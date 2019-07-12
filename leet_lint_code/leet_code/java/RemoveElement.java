// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 27.
// Date: 2019.7.13

class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int removedCnt = 0;
        
        for (int i = 0; i < nums.length; ++ i) {
            if (nums[i] == val) {
                removedCnt ++ ;
            } else {
                nums[i - removedCnt] = nums[i];
            }
        }
        
        return nums.length - removedCnt;
    }
}