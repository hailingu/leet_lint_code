// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 721.
// Date: 2019.9.4

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind unionFind = new UnionFind();
        List<List<String>> ans = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < accounts.size(); ++ i) {
            int len = accounts.get(i).size();
            for (int j = 1; j < len - 1; ++ j) {
                unionFind.union(accounts.get(i).get(j), accounts.get(i).get(j + 1));
                map.put(accounts.get(i).get(j), accounts.get(i).get(0));
            }

            if (len == 2) {
                unionFind.union(accounts.get(i).get(1), accounts.get(i).get(1));
            }

            map.put(accounts.get(i).get(len - 1), accounts.get(i).get(0));
        }


        for (String account : unionFind.forest.keySet()) {
            List<String> t = new ArrayList<>();
            t.addAll(unionFind.forest.get(account));
            Collections.sort(t);
            t.add(0, map.get(account));
            ans.add(t);
        }
  

        return ans;
    }
}
