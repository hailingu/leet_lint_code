// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 360.
// Date: 2019.7.26

class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] ans = new int[nums.length];
        int i = 0;

        if (a == 0 && b == 0) {
            while (i < nums.length) {
                ans[i++] = c;
            }

            return ans;
        } else if (a == 0) {
            while (i < nums.length) {
                ans[i] = nums[i] * b + c;
                ++i;
            }

            if (b < 0) {
                reverse(ans);
            }
        } else {
            double aos = -0.5 * b / a;
            while (i < nums.length && nums[i] < aos) {
                ++i;
            }
            int j = i - 1;
            int q = 0;

            while (j >= 0 && i < nums.length) {
                if (nums[i] - aos > aos - nums[j]) {
                    ans[q ++] = calc(nums[j], a, b, c);
                    --j;
                } else if (nums[i] - aos <= aos - nums[j]) {
                    ans[q ++] = calc(nums[i], a, b, c);
                    ++i;
                }
            }
            
            while (j >= 0) {
                ans[q++] = calc(nums[j--], a, b, c);
            }
            
            while (i < nums.length) {
                ans[q ++] = calc(nums[i ++], a, b, c);
            }

            if (a < 0) {
                reverse(ans);
            }
        }

        return ans;
    }

    int calc(int i, int a, int b, int c) {
        return i * (a * i + b) + c;
    }

    void reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int t = nums[i];
            nums[i ++] = nums[j];
            nums[j --] = t;
        }
    }
}