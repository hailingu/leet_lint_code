// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 289.
// Date: 2019.8.12

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        // 1. live -> dead
        // 2. dead -> live
        // 3. dead -> dead
        // 4. live -> live

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                // positions up down left right

                int cnt = 0;
                // up
                int p = i - 1;
                if (p >= 0 && (board[p][j] == 1 || board[p][j] == 4)) {
                    ++cnt;
                }

                // down
                p = i + 1;
                if (p < board.length && (board[p][j] == 1 || board[p][j] == 4)) {
                    ++cnt;
                }

                // left
                int q = j - 1;
                if (q >= 0 && (board[i][q] == 1 || board[i][q] == 4)) {
                    ++cnt;
                }

                // right
                q = j + 1;
                if (q < board[0].length && (board[i][q] == 1 || board[i][q] == 4)) {
                    ++cnt;
                }

                // up left
                p = i - 1;
                q = j - 1;
                if (p >= 0 && q >= 0 && (board[p][q] == 1 || board[p][q] == 4)) {
                    ++cnt;
                }

                // up right
                q = j + 1;
                if (p >= 0 && q < board[0].length && (board[p][q] == 1 || board[p][q] == 4)) {
                    ++cnt;
                }

                // down left
                p = i + 1;
                q = j - 1;
                if (p < board.length && q >= 0 && (board[p][q] == 1 || board[p][q] == 4)) {
                    ++cnt;
                }

                // down right
                q = j + 1;
                if (p < board.length && q < board[0].length && (board[p][q] == 1 || board[p][q] == 4)) {
                    ++cnt;
                }

                if (board[i][j] == 1) {
                    if (cnt < 2 || cnt > 3) {
                        board[i][j] = 1;
                    } else if (cnt == 2 || cnt == 3) {
                        board[i][j] = 4;
                    }
                } else if (board[i][j] == 0 && cnt == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 4) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
