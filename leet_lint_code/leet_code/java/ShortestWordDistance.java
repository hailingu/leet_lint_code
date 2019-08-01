// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 245.
// Date: 2019.8.1


class ShortestWordDistance {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int i = -1; 
        int j = -1;
        
        int index = 0;
        int ans = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            for (String s : words) {
                if (s.equals(word1)) {
                    if (i == -1) {
                        i = index;
                    } else {
                        ans = Math.min(ans, Math.abs(index - i));
                        i = index;
                    }
                }
                 ++ index;   
            }
        } else {
            for (String s : words) {
                if (s.equals(word1)) {
                    i = index;
                }
                
                if (s.equals(word2)) {
                    j = index;
                }
                
                if (i != -1 && j != -1) {
                    ans = Math.min(ans, Math.abs(j - i));
                }
                ++ index;
            }
        }
        
        return ans;
    }
}