// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 78.
// Date: 2019.7.29

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        
        List<List<Integer>> tmp = new ArrayList<>();
        for (int i : nums) {
             tmp.clear();
            for (List<Integer> list: ans) {
                List<Integer> nList = new ArrayList<Integer>(list);
                nList.add(i);
                tmp.add(nList);
            }

            List<Integer> n = new ArrayList<>();
            n.add(i);
            tmp.add(n);
            ans.addAll(tmp);
        }

        ans.add(new ArrayList<>());
        return ans;
    }
}