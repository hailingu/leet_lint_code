// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 56.
// Date: 2019.8.1

public class GenerateMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        if (n == 1) {
            ans[0][0] = 1;
            return ans;
        }

        int direction = 1;
        int p = 0, q = 0;
        int i = 1, cntBound = n * n;
        int lowerBound = 0, upperBound = n, leftBound = 0, rightBound = n;

        while (i <= cntBound) {
            ans[p][q] = i++;

            if (direction == 1) {
                q ++;
                if (q == rightBound) {
                    lowerBound ++;
                    q = rightBound - 1;
                    p = lowerBound;
                    direction = (direction + 1) % 4;
                }
            } else if (direction == 2) {
                p ++;
                if (p == upperBound) {
                    rightBound --;
                    p = upperBound - 1;
                    q = rightBound - 1;
                    direction = (direction + 1) % 4;
                }
            } else if (direction == 3) {
                q --;
                if (q == leftBound - 1) {
                    upperBound --;
                    q = leftBound;
                    p = upperBound - 1;
                    direction = (direction + 1) % 4;
                }
            } else {
                p --;
                if (p == lowerBound - 1) {
                    leftBound ++;
                    q = leftBound;
                    p = lowerBound;
                    direction = (direction + 1) % 4;
                }
            }
        }
        return ans;
    }
}
