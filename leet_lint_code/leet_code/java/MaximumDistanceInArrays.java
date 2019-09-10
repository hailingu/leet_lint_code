// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: leetcode
// This is a answer of leet code problem 624.
// Date: 2019.9.10

import java.util.List;

public class MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size(); ++ i) {
            List<Integer> arrayI = arrays.get(i);
            ans = Math.max(ans, Math.abs(arrayI.get(0) - max));
            ans = Math.max(ans, Math.abs(arrayI.get(arrayI.size() - 1)) - min);

            max = Math.max(max, arrayI.get(arrayI.size() - 1));
            min = Math.min(min, arrayI.get(0));
        }

        return ans;
    }
}
