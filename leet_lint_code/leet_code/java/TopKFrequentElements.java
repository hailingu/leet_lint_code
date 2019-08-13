// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 347.
// Date: 2019.8.14

import java.util.*;

class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
         TreeMap<Integer, Integer> cntMap = new TreeMap<>();
        TreeMap<Integer, List<Integer>> reverserMap = new TreeMap<>();

        for (int num : nums) {
            int val = 1;

            if (cntMap.containsKey(num)) {
                val = cntMap.get(num) + 1;
                cntMap.put(num, val);
            } else {
                cntMap.put(num, val);
            }
        }
        
        for (Map.Entry<Integer, Integer> kv : cntMap.entrySet()) {
            if (reverserMap.containsKey(kv.getValue())) {
                reverserMap.get(kv.getValue()).add(kv.getKey());
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(kv.getKey());
                reverserMap.put(kv.getValue(), list);
            }
        }


        List<Integer> ans = new ArrayList<>();
        NavigableMap<Integer,List<Integer>>  reverserMap2 = reverserMap.descendingMap();
        for (Map.Entry<Integer, List<Integer>> kv : reverserMap2.entrySet()) {
            ans.addAll(kv.getValue());
            if (ans.size() == k) {
                break;
            }
        }
        return ans;
    }
}