// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 16.
// Date: 2019.8.26

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;

        int dist = Integer.MAX_VALUE;
        int ans = 0;

        while (i < nums.length - 2) {
            if (i > 1 && nums[i] >= nums[i-1] && nums[i - 1] > target) {
                return ans;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int tmpDist = sum - target;

                if (tmpDist == 0) {
                    return target;
                } else if (tmpDist < 0){
                    while (left < nums.length - 1 && nums[left] == nums[left + 1]) ++ left;
                    ++ left;

                    tmpDist = -1 * tmpDist;
                    if (tmpDist < dist) {
                        ans = sum;
                        dist = tmpDist;
                    }

                } else {
                    while (right >= 1 && nums[right - 1] == nums[right]) -- right;
                    -- right;
                    if (tmpDist < dist) {
                        ans = sum;
                        dist = tmpDist;
                    }
                }
            }

            while (i < nums.length - 1 && nums[i + 1] == nums[i]) ++ i;
            ++ i;
        }

        return ans;
    }
}
