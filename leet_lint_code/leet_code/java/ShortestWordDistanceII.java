// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 244.
// Date: 2019.8.8


import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class ShortestWordDistanceII {

    String[] words;
    Map<String, List<Integer>> memo = new HashMap<>();
    public ShortestWordDistanceII(String[] words) {
        this.words = words;
        
        for (int i = 0; i < words.length; ++ i) {
            if (memo.containsKey(words[i])) {
                memo.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                memo.put(words[i], list);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> wordIdx1List = memo.get(word1);
        List<Integer> wordIdx2List = memo.get(word2);
        
        int i = 0;
        int j = 0;
        
        int ans = Integer.MAX_VALUE;
        while (i < wordIdx1List.size() && j < wordIdx2List.size()) {
            ans = Math.min(ans, Math.abs(wordIdx1List.get(i) - wordIdx2List.get(j)));
            if (wordIdx1List.get(i) < wordIdx2List.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return ans;
    }
}