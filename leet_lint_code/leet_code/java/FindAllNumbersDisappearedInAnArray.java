// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 448.
// Date: 2019.8.23

import java.util.List;
import java.util.ArrayList;

class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      int[] back = new int[nums.length];
        
      List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
          if (num != 0) {
            back[num - 1] = 1;
          }
        }
      
        for (int i = 0; i < back.length; ++ i) {
          if (back[i] != 1) {
            ans.add(i + 1);
          }
        }
      
        return ans;
    }
}