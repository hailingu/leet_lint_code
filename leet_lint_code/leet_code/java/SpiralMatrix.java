// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 54.
// Date: 2019.9.12

import java.util.List;
import java.util.ArrayList;


class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = m > 0 ? matrix[0].length : 0;
        List<Integer> ans = new ArrayList<>();

        if (m == 0 || n == 0) {
            return ans;
        }

        int is = 0;
        int ie = m - 1;

        int cs = 0;
        int ce = n - 1;

        int total = m * n;
        int direction = 1;

        while (ans.size() != total) {
            iterate(matrix, ans, is, ie, cs, ce, direction);
            if (direction == 1) {
                is ++;
            } else if (direction == 2) {
                ce --;
            } else if (direction == 3) {
                ie --;
            } else {
                cs ++;
            }
            direction = (direction + 1) % 4;
        }

        return ans;
    }

    void iterate(int[][] matrix, List<Integer> ans, int is, int ie, int cs, int ce, int direction) {
        int i = is;
        int j = cs;
        if (direction == 1) {
            // left -> right
            i = is;
            j = cs;
            while (j <= ce) {
                ans.add(matrix[i][j++]);
            }
        } else if (direction == 2) {
            // up -> down
            i = is;
            j = ce;
            while (i <= ie) {
                ans.add(matrix[i ++][j]);
            }
        } else if (direction == 3) {
            // right -> left
            i = ie;
            j = ce;
            while (j >= cs) {
                ans.add(matrix[i][j --]);
            }
        } else {
            // down -> up
            i = ie;
            j = cs;
            while (i >= is) {
                ans.add(matrix[i --][j]);
            }
        }
    }
}