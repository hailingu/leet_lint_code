// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 1099.
// Date: 2019.8.22



import java.util.TreeSet;

class TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
      TreeSet<Integer> set = new TreeSet<>();
      
      int ans = -1;
      for (int a : A) {
        Integer residual = set.floor(K - a - 1);
        if (residual != null) {         
          ans = Math.max(ans, residual + a);
        }
        set.add(a);
      }
      return ans;
    }
}