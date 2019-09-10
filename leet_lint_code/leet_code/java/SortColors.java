// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: leetcode
// This is a answer of leet code problem 75.
// Date: 2019.9.10


class SortColors {
    public void sortColors(int[] nums) {
        int twoCnt = 0;
        int oneCnt = 0;
        int zeroCnt = 0;
        
        for (int num : nums) {
            if (num == 0) {
                ++ zeroCnt;
            } else if (num == 1) {
                ++ oneCnt;
            } else {
                ++ twoCnt;
            }
        }
        
        int idx = 0;
        while (idx < zeroCnt) {
            nums[idx ++] = 0;
        }
        
        idx = 0;
        while (idx < oneCnt) {
            nums[zeroCnt + idx] = 1;
            ++ idx;
        }
        
        idx = 0;
        while (idx < twoCnt) {
            nums[zeroCnt + oneCnt + idx] = 2;
            ++ idx;
        }
        return ;
    }
}