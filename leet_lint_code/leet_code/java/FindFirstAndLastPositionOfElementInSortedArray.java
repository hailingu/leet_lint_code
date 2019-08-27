// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 34.
// Date: 2019.8.27

class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int idx = searchHelp(nums, 0, nums.length - 1, target);
        if (idx == -1) {
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        
        ans[0] = idx;
        int j = idx + 1;
        while (j < nums.length && nums[j] == nums[idx]) ++ j;
        -- j;
        while (idx >= 0 && nums[idx] == nums[j]) --idx;
        ans[1] = j;
        ans[0] = idx + 1;
        return ans;
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
}