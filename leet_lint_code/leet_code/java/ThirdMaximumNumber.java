// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 414.
// Date: 2019.8.22

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        int j = nums.length - 1;
        while (set.size() != 3 && j >= 0) {
            set.add(nums[j]);
            -- j;
        }
        
        if (set.size() < 3) {
            return nums[nums.length - 1];
        } else {
            return nums[j + 1];
        }
    }
}