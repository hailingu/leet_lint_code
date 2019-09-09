// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 477.
// Date: 2019.9.7

class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        int zeroCnt = 0;
        while (zeroCnt < nums.length) {
            zeroCnt = 0;
            int numOfOne = 0;
            for (int i = 0; i < nums.length; ++ i) {
                if (nums[i] != 0) {
                    if ((nums[i] & 1) == 1) {
                        ++ numOfOne;
                    }
                } else {
                    zeroCnt ++;
                }
                nums[i] = nums[i] >>> 1;
            }
            
            ans += (nums.length - numOfOne) * numOfOne;
        }
        return ans;
    }
}