// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 35.
// Date: 2019.7.17

class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++ i) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
}