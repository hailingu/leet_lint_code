// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 11.
// Date: 2019.8.11


class ContainerWithMostWater {
    public int maxArea(int[] height) {        
        int i = 0;
        int j = height.length - 1;
        int ans = 0;
        
        while (i < j) {
            ans = Math.max(ans, (j - i) * Math.min(height[i], height[j]));
            if (height[i] > height[j]) {
                -- j;
            } else {
                ++ i;
            }
        }
        
        return ans;
    }
}