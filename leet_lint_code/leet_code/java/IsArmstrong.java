// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 1134.
// Date: 2019.7.29

import java.util.List;
import java.util.ArrayList;;


class IsArmstrong {
    public boolean isArmstrong(int N) {
        int copyN = N;
        
        List<Integer> digit = new ArrayList<>();
        while (N > 0) {
            digit.add(N % 10);
            N = N / 10;
        }
        
        long sum = 0;
        for (int d : digit) {
            sum += Math.pow(d, digit.size());
        }
        
        return sum == copyN;
    }
}