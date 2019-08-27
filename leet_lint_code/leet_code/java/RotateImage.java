// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 48.
// Date: 2019.8.27


class RotateImage {
    public void rotate(int[][] matrix) {
        for (int layer = 0; layer < matrix.length ; ++ layer) {
            int dist = matrix.length - 2 * layer - 1;
            if (dist > 0) {
                rotate(matrix, layer, matrix.length, dist);
            } else {
                return ;
            }
        }

        System.out.println("");
    }

    void rotate(int[][] matrix, int layer, int len, int dist) {
        int range = len - layer - 1;
        for (int i = layer; i < range; ++ i) {
            int idx = layer;
            int idy = i;
            int tmp = matrix[idx][idy];
            for (int j = 0; j < 4; ++ j) {
                int nextIdx = idy;
                int nextIdy = idx + dist;
                if (nextIdy > range) {
                    nextIdy = range - (nextIdy - range);
                }

                int tmp2 = matrix[nextIdx][nextIdy];
                matrix[nextIdx][nextIdy] = tmp;
                tmp = tmp2;
                idx = nextIdx;
                idy = nextIdy;
            }
        }
    }
}