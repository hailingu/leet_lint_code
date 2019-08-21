// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 118.
// Date: 2019.8.21


import java.util.List;
import java.util.ArrayList;

class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < numRows; ++ i) {
            List<Integer> levelAns = new ArrayList<>();
            
            if (ans.size() == 0) {
                levelAns.add(1);
                ans.add(levelAns);
            } else if (ans.size() == 1) {
                levelAns.add(1);
                levelAns.add(1);
                ans.add(levelAns);
            } else {
                levelAns.add(1);
                
                List<Integer> prev = ans.get(i - 1);
                for (int q = 1; q < i; q ++) {
                    levelAns.add(prev.get(q-1) + prev.get(q));
                }
                
                levelAns.add(1);
                ans.add(levelAns);
            }
        } 
        return ans;
    }
}