// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailingu
// This is a answer of leet code problem 7.
// Date: 2019.8.9

class ReverseInteger {
    public int reverse(int x) {
     if (Integer.MIN_VALUE == x || Integer.MAX_VALUE == x) return 0;
     long ret = 0;

      while (0 != x) {
        ret = ret * 10 + x % 10;
        x = x / 10;
      }

      if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) return 0;
      return (int)ret;
    }
}