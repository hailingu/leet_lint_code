// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 760.
// Date: 2019.8.8

import java.util.Map;
import java.util.HashMap;

class FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        int[] ans = new int[B.length];
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (i < B.length) {
            map.put(B[i], i ++);
        }
        
        i = 0;
        while (i < A.length) {
            ans[i] = map.get(A[i++]);
        }
        
        return ans;
    }
}