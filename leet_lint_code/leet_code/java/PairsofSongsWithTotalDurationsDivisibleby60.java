// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 1010.
// Date: 2019.8.24

import java.util.Map;
import java.util.HashMap;

class PairsofSongsWithTotalDurationsDivisibleby60 {
    public int numPairsDivisibleBy60(int[] time) {
        Arrays.sort(time);
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int t : time) {
            for (int i = 1; i < 20; ++ i) {
                if (map.containsKey(60 * i - t)) {
                    ans += map.get(60 * i - t);
                }
            }
            
            map.put(t, map.getOrDefault(t,0) + 1);
        }
        
        return ans;
    }
}