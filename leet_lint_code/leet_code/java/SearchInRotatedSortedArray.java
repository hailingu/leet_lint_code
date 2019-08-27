// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 33.
// Date: 2019.8.27

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            if (target == nums[0]) {
                return 0;
            }
            return -1;
        }

        int pvoit = searchHelp(nums, 0, nums.length - 1);
        if (pvoit == -1) {
            return searchHelp(nums, 0, nums.length - 1, target);
        }

        if (target == nums[pvoit]) {
            return pvoit;
        }

        if (target >= nums[0] && target < nums[pvoit]) {
            return searchHelp(nums, 0, pvoit, target);
        } else {
            return searchHelp(nums, pvoit + 1, nums.length - 1, target);
        }
    }

    int searchHelp(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    int searchHelp(int[] nums, int left, int right) {
        int mid = (left + right) / 2;

        if (mid > 0 && nums[mid] > nums[mid - 1] && mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
            return mid;
        } else if (mid == 0 && nums[mid] > nums[mid + 1]) {
            return mid;
        } else if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
            return mid;
        }

        if (nums[mid] > nums[left]) {
            return searchHelp(nums, mid + 1, right);
        } else if (nums[mid] < nums[left]) {
            return searchHelp(nums, left, mid - 1);
        } else if (nums[mid] < nums[right]){
            return searchHelp(nums, mid + 1, right);
        } else {
            return -1;
        }
    }
}
