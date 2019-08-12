// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 162.
// Date: 2019.8.11

class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        
        return findPeakElement(nums, 0, nums.length - 1);
    }
    
    int findPeakElement(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (mid == 0 && nums[mid + 1] < nums[mid]) {
            return mid;
        }

        if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
            return mid;
        }

        if (mid >= 1 && mid <= nums.length - 1 && nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
            return mid;
        }

        int idx = findPeakElement(nums, mid + 1, right);
        int idx2 = findPeakElement(nums, left, mid - 1);

        if (idx2 != -1) {
            return idx2;
        } else {
            return idx;
        }
    }
}