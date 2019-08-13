// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 239.
// Date: 2019.8.12

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> windows = new TreeMap<>();
        int[] ans;
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            if (windows.containsKey(nums[i])) {
                int value = windows.get(nums[i]);
                windows.put(nums[i], value + 1);
            } else {
                windows.put(nums[i], 1);
            }

        }

        for (int i = k; i < nums.length; ++i) {
            ansList.add(windows.lastKey());

            // remove
            int value = windows.get(nums[i - k]);
            value--;
            if (value == 0) {
                windows.remove(nums[i - k]);
            } else {
                windows.put(nums[i - k], value);
            }

            // add
            value = 1;
            if (windows.containsKey(nums[i])) {
                value = windows.get(nums[i]);
                value++;
            }
            windows.put(nums[i], value);
        }

        ansList.add(windows.lastKey());
        ans = new int[ansList.size()];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }
}
