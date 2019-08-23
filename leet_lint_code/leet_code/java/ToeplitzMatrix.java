// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 766.
// Date: 2019.8.24

class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++ i) {
            int j = i + 1;
            if (j < matrix.length) {
                int m = 0;
                int n = 1;
                while (m < matrix[0].length - 1 && n < matrix[0].length) {
                    if (matrix[i][m] != matrix[j][n]) {
                        return false;
                    } 
                    ++ m;
                    ++ n;
                }
            }
        }
        
        return true;
    }
}
