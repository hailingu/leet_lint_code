// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 844.
// Date: 2019.8.8

class BackSpaceCompare {
  public boolean backspaceCompare(String S, String T) {
    int i = S.length() - 1, j = T.length() - 1, sback = 0, tback = 0;
    while (true) {
      while (i >= 0 && S.charAt(i) == '#') {
        ++ sback;
        -- i;
      }

      while (j >= 0 && T.charAt(j) == '#' ) {
        ++ tback;
        -- j;
      }

      while (sback > 0 &&  i >= 0 && S.charAt(i) != '#') {
        -- i;
        -- sback;
      }

      while (tback > 0 && j >= 0 && T.charAt(j) != '#') {
        -- j;
        -- tback;
      }

      if (j >= 0 && T.charAt(j) == '#') continue;
      if (i >= 0 && S.charAt(i) == '#') continue;
      if (i < 0 && j < 0) return true;
      if (i < 0 && j >= 0) return  false;
      if (i >= 0 && j < 0) return  false;

      if (S.charAt(i) == '#' || T.charAt(j) == '#') continue;
      if (S.charAt(i) != T.charAt(j)) return false;
      -- i;
      -- j;
      }
    }
}
