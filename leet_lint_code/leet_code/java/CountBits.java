// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 338.
// Date: 2019.8.2

class CountingBits {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; ++ i) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
}