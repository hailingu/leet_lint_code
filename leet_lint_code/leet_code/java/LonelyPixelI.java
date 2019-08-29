// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 531.
// Date: 2019.8.29

public class LonelyPixelI {
    public int findLonelyPixel(char[][] picture) {
        if (picture.length == 0) {
            return 0;
        }

        int cnt = 0;

        for (int i = 0; i < picture.length; ++ i) {
            for (int j = 0; j < picture[0].length; ++ j) {
                if (picture[i][j] == 'B') {
                    boolean test = dfs(picture, i - 1, j, 1);
                    if (test) test = dfs(picture, i + 1, j, 2);
                    if (test) test = dfs(picture, i, j - 1, 3);
                    if (test) test = dfs(picture, i, j + 1, 4);
                    if (test) ++ cnt;
                }
            }
        }

        return cnt;
    }

    boolean dfs(char[][] picture, int i, int j, int direction) {
        int r = picture.length;
        int c = picture[0].length;

        if (i < 0 || j < 0 || i >= r || j >= c) {
            return true;
        } else if (picture[i][j] == 'B') {
            return false;
        }

        picture[i][j] = 'C';
        if (direction == 1) {
            return dfs(picture, i - 1, j, direction);
        } else if (direction == 2) {
            return dfs(picture, i + 1, j, direction);
        } else if (direction == 3) {
            return dfs(picture, i, j - 1, direction);
        } else {
            return dfs(picture, i, j + 1, direction);
        }
    }
}
