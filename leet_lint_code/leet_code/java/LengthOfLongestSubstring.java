// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 3.
// Date: 2019.7.25

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int ans = 0;
        int mAns = 0;

        while (i < s.length()) {
            if (map.containsKey(s.charAt(i))) {
                int t = map.get(s.charAt(i));
                ans = Math.max(ans, mAns);
                mAns = i - t;
                while (j <= t) {
                    map.remove(s.charAt(j++));
                }
            } else {
                mAns ++;
            }
            
            map.put(s.charAt(i), i);
            i ++;
           
        }

        ans = Math.max(ans, map.size());
        return ans;
    }
}