// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 1160.
// Date: 2019.8.23

import java.util.HashMap;


class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) 
    {
        if (words.length == 0 || chars.length() == 0) return 0;
        
        char[] ch = chars.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        int ans = 0;
        for (char c : ch) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        
        for (String word : words) {
            char[] cc = word.toCharArray();
            HashMap<Character,Integer> temp = (HashMap)map.clone();
            int j = 0;
            while (j < cc.length && temp.containsKey(cc[j])) {
                int left = temp.get(cc[j]) - 1;
                if (left == 0) {
                    temp.remove(cc[j]);
                } else {
                    temp.put(cc[j], left);
                }
                ++ j;
            }
            
            if (j == cc.length) {
                ans += j;
            }
        }
        return ans;
    }
}