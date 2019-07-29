// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 523.
// Date: 2019.7.15

import java.util.HashMap;
import java.util.Map;


class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
     if (nums.length < 2) {
            return false;
        }

        for (int i = 0; i < nums.length - 1; ++i) {
                if (nums[i] == nums[i + 1] && nums[i] == 0) {
                    return true;
                }
            }
        
        if (k == 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int sum = nums[0];
        map.put(sum % k, sum);
        map2.put(sum % k, 0);

        for (int i = 1; i < nums.length; ++i) {
            sum += nums[i];

            int left = sum % k;
            if (left == 0) {
                return true;
            }

            if (map.containsKey(left)) {
                int temp = sum - map.get(left);
                if (temp >= k && temp % k == 0 && i - map2.get(left) > 1)
                    return true;
            } else {
                map.put(left, sum);
                map2.put(left, i);
            }
        }

        return false;
    }
}