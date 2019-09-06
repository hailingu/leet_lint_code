// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 785.
// Date: 2019.9.6

class IsGraphBipartite {
    boolean isPartite = true;
    public boolean isBipartite(int[][] graph) {
        int[] marked = new int[graph.length];
        Arrays.fill(marked, -1);
        int color = 0;
        for (int i = 0; i < graph.length; ++ i) {
            dfs(graph, i, marked, color);
            color = (color + 1) % 2;
        }
        
        return isPartite;
    }
    
    void dfs(int[][] graph, int i, int[] marked, int color) {
        if (marked[i] != -1) {
            return;
        }
        
        if (!isPartite) {
            return ;
        }
        
        marked[i] = color;
        for (int neighbour : graph[i]) {
            if (marked[neighbour] == -1) {
                dfs(graph, neighbour, marked, (color + 1) % 2);
            } else if (marked[neighbour] == color) {
                isPartite = false;
            }
        }
    }
}