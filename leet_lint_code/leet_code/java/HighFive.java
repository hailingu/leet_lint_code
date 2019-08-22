// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 1086.
// Date: 2019.8.22

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class HiveFive {
    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ansLst = new ArrayList<>();
        
        int i = 0;
        while (i < items.length) {
            int[] scores = items[i];
            if (map.containsKey(scores[0])) {
                map.get(scores[0]).add(scores[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(scores[1]);
                map.put(scores[0], list);
            }
            ++ i;
        }
        
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int sum = 0;
            List<Integer> list = entry.getValue();
            Collections.sort(list);
            for (i = 0; i < 5; ++ i) {
                sum += list.get(list.size() - 1 - i);
            }
            
            List<Integer> tmpAns = new ArrayList<>();
            tmpAns.add(entry.getKey());
            tmpAns.add(sum / 5);
            ansLst.add(tmpAns);
        }
        
        int[][] ans = new int[ansLst.size()][2];
        for (List<Integer> lst : ansLst) {
            ans[lst.get(0) - 1][0] = lst.get(0);
            ans[lst.get(0) - 1][1] = lst.get(1);
        }
        
        
        return ans;
    }
}