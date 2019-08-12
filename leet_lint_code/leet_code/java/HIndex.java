// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 274.
// Date: 2019.8.11

import java.util.Arrays;

class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        
        int h = 0;
        for (int i = 0; i < citations.length; ++ i) {
            h = citations.length - i;
            if (h <= citations[i]) {
                return h;
            }
        }
        
        return 0;
    }
}