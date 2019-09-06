// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 323.
// Date: 2019.9.5


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind();

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        int ans = uf.size.size();
        for (int i = 0; i < n; ++ i) {
            if (!uf.visited.contains(i)) ++ ans;
        }

        return ans;
    }
}

class UnionFind {
    HashMap<Integer, Integer> parent;
    HashMap<Integer, Integer> size;

    Set<Integer> visited;

    UnionFind() {
        parent = new HashMap<>();
        size = new HashMap<>();
        visited = new HashSet<>();
    }

    void union(int i, int j) {
        init(i);
        init(j);

        int pi = find(i);
        int pj = find(j);

        if (pi != pj) {
            int sizeI = size.get(pi);
            int sizeJ = size.get(pj);

            if (sizeI > sizeJ) {
                size.put(pi, sizeI + sizeJ);
                parent.put(pj, pi);
                size.remove(pj);
            } else {
                size.put(pj, sizeI + sizeJ);
                parent.put(pi, pj);
                size.remove(pi);
            }
        }
    }

    int find(int i) {
        init(i);

        while (i != parent.get(i)) {
            i = parent.get(i);
        }

        return i;
    }

    void init(int i) {
        if (!parent.containsKey(i)) {
            parent.put(i, i);
            size.put(i, i);
            visited.add(i);
        }
    }
}
