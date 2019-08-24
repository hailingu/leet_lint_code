// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 697.
// Date: 2019.8.24


import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

class  DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++ i) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        
        int ans = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() > max) {
                max = list.size();
                ans = list.get(list.size() - 1) - list.get(0) + 1;
            } else if (list.size() == max){
                ans = Math.min(ans, list.get(list.size() - 1) - list.get(0) + 1);
            }
        }
         
        return ans;        
    }
}