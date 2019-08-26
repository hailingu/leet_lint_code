// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 36.
// Date: 2019.8.25

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int[] test;

        // row check
        for (int i = 0; i < 9; ++ i) {
            test = new int[10];
            char[] row = board[i];
            for (int j = 0; j < 9; ++ j) {
                if (row[j] != '.') {
                    int idx = row[j] - '0';
                    test[idx] ++;
                    if (test[idx] > 1) {
                        return false;
                    }
                }
            }
        }

        // column check
        for (int i = 0; i < 9; ++ i) {
            test = new int[10];
            for (int j = 0; j < 9; ++ j) {
                char c = board[j][i];
                if (c != '.') {
                    int idx = c - '0';
                    test[idx] ++;
                    if (test[idx] > 1) {
                        return false;
                    }
                }
            }
        }

        // small box check
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean temp = smallBoxCheck(board, i, j);
                if (!temp) {
                    return temp;
                }
            }
        }

        // result
        return true;
    }

    boolean smallBoxCheck(char[][] board, int m, int n) {
        int[] test = new int[10];
        int i = m;

        while (i < m + 3) {
            int j = n;
            while (j < n + 3) {
                char c = board[i][j];
                if (c != '.') {
                    int idx = c - '0';
                    test[idx] ++;
                    if (test[idx] > 1) {
                        return false;
                    }
                }
                ++ j;
            }
            ++ i;
        }
        return true;
    }
}