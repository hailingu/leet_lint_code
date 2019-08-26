// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 15.
// Date: 2019.8.26

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        int i = 0;

        while (i < nums.length - 2) {
            if (nums[i] > 0) {
                return ans;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                List<Integer> list = new ArrayList<>();
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    while (right >= 0 && nums[right - 1] == nums[right]) -- right;
                    -- right;
                    while (left < nums.length - 1&& nums[left] == nums[left + 1]) ++ left;
                    ++ left;
                } else if (sum < 0){
                    while (left < nums.length - 1&& nums[left] == nums[left + 1]) ++ left;
                    ++ left;

                } else {
                    while (right >= 0 && nums[right - 1] == nums[right]) -- right;
                    -- right;
                }
            }
            ++ i;
        }

        return ans;
    }
}
