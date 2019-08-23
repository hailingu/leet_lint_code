// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 922.
// Date: 2019.8.23

class SortArrayByParity {
    public int[] sortArrayByParityII(int[] A) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
      
        for (int a : A) {
          if (a %2 == 0) {
            even.add(a);
          } else {
            odd.add(a);
          }
        }
            
        int i = 0;
        int m = 0;
        int n = 0;
        
        while (i < A.length) {
          if ( i %2 == 1) {
            A[i ++] = odd.get(m ++);
          } else {
            A[i ++] = even.get(n ++);
          }
        }
        
        return A;
    }
}