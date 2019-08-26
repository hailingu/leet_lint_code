// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 18.
// Date: 2019.8.26

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; ) {
            for (int j = i + 1; j < nums.length - 2; ) {
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ans.add(list);
                        while (right >= 1 && nums[right - 1] == nums[right]) -- right;
                        -- right;
                        while (left < nums.length - 1 && nums[left] == nums[left + 1]) ++ left;
                        ++ left;
                    } else if (sum < target) {
                        while (left < nums.length - 1 && nums[left] == nums[left + 1]) ++ left;
                        ++ left;
                    } else {
                        while (right >= 1 && nums[right - 1] == nums[right]) -- right;
                        -- right;
                    }
                }
                while (j < nums.length - 1 && nums[j + 1] == nums[j]) ++ j;
                ++ j;
            }
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) ++ i;
            ++ i;
        }
        return ans;
    }
}
