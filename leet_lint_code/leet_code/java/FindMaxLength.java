// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 525.
// Date: 2019.7.15

import java.util.HashMap;
import java.util.Map;

public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int ans = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++ i) {
            if (nums[i] == 0) {
                left --;
            } else {
                left ++;
            }

            if (left == 0) {
                ans = Math.max(ans, i + 1);
            }

            if (map.containsKey(left)) {
                ans = Math.max(ans, i - map.get(left));
            } else {
                map.put(left, i);
            }
        }


        return ans;
    }
}