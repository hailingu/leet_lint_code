// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 696.
// Date: 2019.9.10

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        if (s == null || s.length() == 0) {
            return ans;
        }

        int i = 0;
        while (i < s.length() - 1) {
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) ++ j;
            int m = j + 1;
            while (m < s.length() && s.charAt(m) == s.charAt(j)) ++ m;

            if (m <= s.length()) {
                if (j - i <= m - j) {
                    ans += j - i;
                } else {
                    ans += m - j;
                }
            }

            i = j;
        }

        return ans;
    }
}
