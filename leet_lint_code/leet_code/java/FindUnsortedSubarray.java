// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 581.
// Date: 2019.7.16

class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
       if (nums.length == 0) {
            return 0;
        }

        int left = 0;
        while (left < nums.length - 1 && nums[left] <= nums[left + 1]) {
            ++left;
        }

        if (left == nums.length - 1) {
            return 0;
        }

        int right = nums.length - 1;
        while (nums[right] >= nums[right - 1]) {
            right--;
        }

        int i = left + 1;
        int min = nums[i];
        int j = right - 1;
        int max = nums[j];

        while (i < nums.length) {
            min = min < nums[i] ? min : nums[i];
            i ++ ;
        }

        while (j > -1){
            max = max > nums[j] ? max : nums[j];
            -- j;
        }

        i = 0;
        while (i < nums.length && min >= nums[i]) {
            i ++ ;
        }

        j = nums.length - 1;
        while (j > -1 && max <= nums[j]) {
            -- j;
        }

        return j - i + 1;
    }
}