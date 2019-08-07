// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 830.
// Date: 2019.8.8

import java.util.List;
import java.util.ArrayList;

class PositionsOfLargeGroups {
  public List<List<Integer>> largeGroupPositions(String S) {
    int i = 0, j = 1;
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    while (i < S.length()) {
      j = i + 1;
      while ( j < S.length() && S.charAt(i) == S.charAt(j)) ++ j;
      if (j >= i + 3) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(i);
        list1.add(j - 1);
        list.add(list1);
        }
      i = j;
    }
    return list;
  }
}
