// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 153.
// Date: 2019.7.23

class FindMin {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return findMinHelp(nums, 0, nums.length - 1);
    }

    int findMinHelp(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }

        int middle = (left + right) / 2;

        if (nums[middle] < nums[right]) {
            return Math.min(nums[middle], findMinHelp(nums, left, middle - 1));
        } else {
            return Math.min(findMinHelp(nums, left, middle - 1), findMinHelp(nums, middle + 1, right));
        }
    }

}