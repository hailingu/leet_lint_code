// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 280.
// Date: 2019.8.1

class WiggleSort {
    public void wiggleSort(int[] nums) {
        int order = 1;
        int i = 0, j = 1;
        while (i < nums.length && j < nums.length) {
            if (order == 1) {
                if (nums[i] > nums[j]) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }

                order = 0;
            } else {
                if (nums[i] < nums[j]) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
                order = 1;
            }
            ++i;
            ++j;
        }
    }
}