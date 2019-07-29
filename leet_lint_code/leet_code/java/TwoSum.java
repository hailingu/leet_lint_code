// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 1.
// Date: 2019.7.2

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ret = new int[2];

        for (int i = 0; i < nums.length; ++i) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                int index1 = map.get(value);
                ret[0] = index1 < i ? index1 : i;
                ret[1] = index1 > i ? index1 : i;
            } else {
                map.put(nums[i], i);
            }
        }
        return ret;
    }
}