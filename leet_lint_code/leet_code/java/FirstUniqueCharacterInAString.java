// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 387.
// Date: 2019.8.25


import java.util.Map;
import java.util.HashMap;

class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        char[] cc = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : cc) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int idx = 0;
        for (char c : cc) {
            int cnt = map.get(c);
            if (cnt == 1) {
                return idx;
            }
            
            ++ idx;
        }
        
        return -1;
    }
}