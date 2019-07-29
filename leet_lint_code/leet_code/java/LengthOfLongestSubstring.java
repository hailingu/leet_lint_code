// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 3.
// Date: 2019.7.25

import java.util.HashMap;
import java.util.Map;

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int ans = 0;

        while (i < s.length()) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)), j);
            }
            
            ans = Math.max(ans, i - j + 1);
            map.put(s.charAt(i), i + 1);
            i ++;
        }
        return ans;
    }
}