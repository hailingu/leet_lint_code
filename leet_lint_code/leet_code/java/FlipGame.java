// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 293.
// Date: 2019.8.9

import java.util.List;
import java.util.ArrayList;

class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < s.length() - 1) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i, '-');
                sb.setCharAt(i + 1, '-');
                ans.add(sb.toString());
            }
            ++ i;
        }   
        return ans;
    }
    
}