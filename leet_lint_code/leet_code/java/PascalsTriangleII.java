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
        return (factorial(BigInteger.valueOf(n), BigInteger.valueOf(n - m + 1)).divide(factorial(BigInteger.valueOf(m), BigInteger.valueOf(1)))).intValueExact();
    }
    
    BigInteger factorial(BigInteger n, BigInteger end) {
        if (n.intValueExact() == 1 || n.intValueExact() == end.intValueExact() ) {
            return n;
        }
        
        
        return n.multiply(factorial(n.subtract(BigInteger.valueOf(1)), end));
    }
}