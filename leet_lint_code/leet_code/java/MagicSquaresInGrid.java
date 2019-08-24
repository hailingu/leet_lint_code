// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 840.
// Date: 2019.8.24

class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int row=grid.length, column=grid[0].length, answer=0;


        for (int i = 2; i < row; i++) {
            for (int j = 2; j < column; j++) {

                if (grid[i-1][j-1] != 5)
                    continue;

                if ((grid[i-2][j-2]+grid[i-2][j-1]+grid[i-2][j] != 15)
                    || (grid[i-1][j-2]+grid[i-1][j] != 10)
                    || (grid[i][j-2]+grid[i][j-1]+grid[i][j] != 15)

                    || (grid[i-2][j-2]+grid[i-1][j-2]+grid[i][j-2] != 15)
                    || (grid[i-2][j-1]+grid[i][j-1] != 10)
                    || (grid[i-2][j]+grid[i-1][j]+grid[i][j] != 15)

                    || (grid[i-2][j-2]+grid[i][j] != 10)
                    || (grid[i-2][j]+grid[i][j-2] != 10)
                )
                    continue;
                if (grid[i-2][j-2]<1 || grid[i-2][j-1]<1 || grid[i-2][j]<1
                    || grid[i-1][j-2]<1 || grid[i-1][j]<1
                    || grid[i][j-2]<1 || grid[i][j-1]<1 || grid[i][j]<1)
                    continue;
                if (grid[i-2][j-2] == 5)
                    continue;
                answer++;
            }
        }
        return answer;
    }
}
