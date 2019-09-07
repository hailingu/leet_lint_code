// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 733.
// Date: 2019.9.7

class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = m > 0 ? image[0].length : 0;
        if (m == 0 || n == 0) {
            return image;
        }
        
        int originColor = image[sr][sc];
        dfs(image, sr, sc, m, n, originColor, -1);
        dfs(image, sr, sc, m, n, -1, newColor);
                
        return image;
    }
    
    void dfs(int[][] image, int sr, int sc, int m, int n, int originColor, int newColor) {
        if (sr < 0 || sc < 0 || sr >= m || sc >= n || image[sr][sc] != originColor) {
            return;
        }
        
        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc, m, n, originColor, newColor);
        dfs(image, sr + 1, sc, m, n, originColor, newColor);
        dfs(image, sr, sc - 1, m, n, originColor, newColor);
        dfs(image, sr, sc + 1, m, n, originColor, newColor);
    }
}