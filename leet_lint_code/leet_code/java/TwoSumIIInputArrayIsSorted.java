// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 167.
// Date: 2019.8.23

class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int temp = numbers[i] + numbers[j];
            if (temp > target) {
                -- j;
            } else if (temp < target) {
                ++ i;
            } else {
                ans[0] = i + 1;
                ans[1] = j + 1;
                return ans;
            }
        }
        
        return ans;
    }
}