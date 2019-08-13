// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 201.
// Date: 2019.8.13

public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }

        int i = 0;
        while (m != n){
            m = m >> 1;
            n = n >> 1;
            ++ i;
        }

        return  m << i;
    }
}