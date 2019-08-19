// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 506.
// Date: 2019.8.19

import java.util.*;

public class RelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
        String[] ans = new String[nums.length];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++ i) {
            map.put(i, nums[i]);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            int compare = (o1.getValue()).compareTo(o2.getValue());
            return -compare;
        });

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list){
            if (i == 0) {
                ans[entry.getKey()] = "Gold Medal";
            } else if (i == 1) {
                ans[entry.getKey()] = "Silver Medal";
            } else if (i == 2) {
                ans[entry.getKey()] = "Bronze Medal";
            } else {
                ans[entry.getKey()] = String.valueOf(i + 1);
            }
            ++ i;
        }

        return ans;
    }
}
