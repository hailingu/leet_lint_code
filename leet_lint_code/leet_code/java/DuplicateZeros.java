// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 1089.
// Date: 2019.8.22


import java.util.List;
import java.util.ArrayList;

class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int a : arr) {
          list.add(a);
          if (a == 0) {
            list.add(0);
          } 
        }
      
        for (int i = 0; i < list.size() && i < arr.length; ++ i) {
          arr[i] = list.get(i);
        }
    }
}