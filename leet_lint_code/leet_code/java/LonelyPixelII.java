// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 533.
// Date: 2019.8.29

import java.util.HashSet;
import java.util.Set;

public class LonelyPixelII {
    public int findBlackPixel(char[][] picture, int N) {
        if (picture.length == 0) {
            return 0;
        }

        int ans = 0;
        Set<Integer> validRows = new HashSet<>();
        Set<Integer> invalidRows = new HashSet<>();
        Set<Integer> validColumns = new HashSet<>();
        Set<Integer> invalidColumns = new HashSet<>();

        for (int i = 0; i < picture.length; ++ i) {
            for (int j = 0; j < picture[0].length; ++ j) {
                if (picture[i][j] == 'B' && validRows.contains(i) && validColumns.contains(j)) {
                    // check
                    boolean test = true;
                    for (int q = 0; q < picture.length; ++ q) {
                        if (q != i && picture[q][j] == 'B') {
                            if (test) test = isSame(picture, i, q);
                            else break;
                        }
                    }

                    if (test) ++ ans;
                    continue;
                }

                if (picture[i][j] == 'B' && !invalidRows.contains(i) && !invalidColumns.contains(j)) {
                    int c = dfs(picture, i - 1, j, 1, 0);
                    c += dfs(picture, i + 1, j, 2, 0);

                    if (c + 1 == N) {
                        validColumns.add(j);
                    } else {
                        invalidColumns.add(j);
                    }

                    int r = dfs(picture, i, j - 1, 3, 0);
                    r += dfs(picture, i, j + 1, 4, 0);

                    if (r + 1 == N) {
                        validRows.add(i);
                    } else {
                        invalidRows.add(i);
                    }

                    if (c + 1 == N && r + 1 == N) {
                        // check
                        boolean test = true;
                        for (int q = 0; q < picture.length; ++ q) {
                            if (q != i && picture[q][j] == 'B') {
                                if (test) test = isSame(picture, i, q);
                                else break;
                            }
                        }
                        if (test) ++ ans;
                    }
                }
            }
        }

        return ans;
    }


    int dfs(char[][] picture, int i, int j, int direction, int cnt) {
        int r = picture.length;
        int c = picture[0].length;

        if (i < 0 || j < 0 || i >= r || j >= c) {
            return cnt;
        }

        if (picture[i][j] == 'B') {
            ++ cnt;
        }

        if (direction == 1) {
            return dfs(picture, i - 1, j, direction, cnt);
        } else if (direction == 2) {
            return dfs(picture, i + 1, j, direction, cnt);
        } else if (direction == 3) {
            return dfs(picture, i, j - 1, direction, cnt);
        } else {
            return dfs(picture, i, j + 1, direction, cnt);
        }
    }

    boolean isSame(char[][] picture, int i, int j) {
        char[] irow = picture[i];
        char[] jrow = picture[j];

        for (int q = 0; q < irow.length; ++ q) {
            if (irow[q] != jrow[q]) {
                return false;
            }
        }
        return true;
    }
}
