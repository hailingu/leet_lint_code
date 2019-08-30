// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 261.
// Date: 2019.8.30


import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0) {
            if (n > 1) {
                return false;
            }
            return true;
        }


        Set<Integer> visited = new HashSet<>();
        HashMap<Integer, List<Integer>> edgesMap = new HashMap<>();
        int start = Integer.MAX_VALUE;

        for (int[] edge : edges) {
            add(edgesMap, edge[0], edge[1]);
            add(edgesMap, edge[1], edge[0]);
            start = Math.min(start, Math.min(edge[0], edge[1]));
        }

        if (start != 0) {
            return false;
        }

        boolean ans = dfs(edgesMap, visited, n, start, -1) && visited.size() == n;
        return ans;
    }

    boolean dfs(HashMap<Integer, List<Integer>> edgesMap, Set<Integer> visited,  int n, int curr, int source) {
        visited.add(curr);
        List<Integer> list = edgesMap.get(curr);

        int idx = 0;
        while (idx < list.size()) {
            int next = list.get(idx);
            if (!visited.contains(next)) {
                dfs(edgesMap, visited, n, list.get(idx), curr);
            } else if (next != source){
                return false;
            }

            ++ idx;
        }

        return true;
    }

    void add(HashMap<Integer, List<Integer>> map, int i, int j) {
        if (map.containsKey(i)) {
            map.get(i).add(j);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(j);
            map.put(i, list);
        }
    }
}
