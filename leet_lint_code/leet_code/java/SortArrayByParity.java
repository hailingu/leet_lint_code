// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 905.
// Date: 2019.8.23


class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
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
      for (int a : even) {
        A[i ++] = a;
      } 
      
      for (int a : odd) {
        A[i ++] = a;
      }
      
      return A;
    }
}