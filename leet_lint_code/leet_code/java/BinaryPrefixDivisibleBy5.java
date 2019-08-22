// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 1018.
// Date: 2019.8.23

class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        int test = A[0];
        if (test % 5 == 0) {
          ans.add(true);
        } else {
          ans.add(false);
        }
        
        for (int i = 1; i < A.length; ++ i) {
          test = test << 1;
          if (A[i] == 1) {
            test = test | 1;
          }
          test %= 5;
          if (test == 0) {
            ans.add(true);
          } else {
            ans.add(false);
          }
        }
        return ans;
      }
}