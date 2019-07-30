// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 3.
// Date: 2019.7.25

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        
        int j = 0;
        int start = 0;
        int ans = 0;
        char c;

        while (j < s.length()) {
            c = s.charAt(j);
            if (map[c] > 0) {
                start = Math.max(map[c], start);
            }
            
            ans = Math.max(ans, j - start + 1);
            map[c] = j + 1;
            j ++;
        }
        return ans;
    }
}