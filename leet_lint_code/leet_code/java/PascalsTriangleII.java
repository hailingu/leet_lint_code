// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 119.
// Date: 2019.8.22

import java.math.BigInteger;

class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        if (rowIndex == 0) {
            ans.add(1);
        } else if (rowIndex == 1) {
            ans.add(1);
            ans.add(1);
            
        } else if (rowIndex == 2) {
            ans.add(1);
            ans.add(2);
            ans.add(1);
        } else if (rowIndex <= 29) {
            ans.add(1);
            for (int q = 1; q < rowIndex; ++ q) {
                ans.add(combination(rowIndex, q));
            }
            ans.add(1);
        } else {
            ans.add(1);
            for (int q = 1; q < rowIndex; ++ q) {
                ans.add(combination(rowIndex, q));
            }
            ans.add(1);
        }
        
        return ans;
    }
    
    int combination(int n, int m) {
        if (m > n / 2) {
            m = n - m;
        }
        
        long upper = n;
        long lower = 1;
        long i = 1;
        while (i < m) {
            upper *= (n - i);
            lower *= (i + 1);
            
            while (upper %2 == 0 && lower %2 == 0) {
                upper = upper / 2;
                lower = lower / 2;
            }
            
            while (upper %3 == 0 && lower %3 == 0) {
                upper = upper / 3;
                lower = lower / 3;
            }
            
            while (upper %5 == 0 && lower %5 == 0) {
                upper = upper / 5;
                lower = lower / 5;
            }
            ++ i;
        }
        
        return (int)(upper / lower);   
    }
}