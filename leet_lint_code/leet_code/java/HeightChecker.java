// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 1051.
// Date: 2019.8.22



import java.util.Arrays;

class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] compare = Arrays.copyOf(heights, heights.length);
        Arrays.sort(compare);
        
        int ans = 0;
        for (int i = 0; i < heights.length; ++ i) {
            if (heights[i] != compare[i]) {
                ++ans;
            }
        }
        
        return ans;
    }
}