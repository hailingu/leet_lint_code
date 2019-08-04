// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 5.
// Date: 2019.7.9

public class LongestPalindrome {

    String longestPalindrome(String s) {
        if (s == null || 0 == s.length()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            sb.append("#").append(s.charAt(i));
        }

        sb.append("#");
        int[] p = new int[sb.length()];
        p[0] = 1;
        int id = 0, mx = 0, hId = 0, hmx = 0;

        for (int i = 1; i < sb.length(); i++) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (i + p[i] < sb.length() && i >= p[i] &&
                    sb.charAt(i + p[i]) == sb.charAt(i - p[i])) {
                p[i]++;
            }

            if (i + p[i] > mx) {
                mx = i + p[i];
                id = i;

                if (p[i] > p[hId]) {
                    hId = id;
                    hmx = mx;
                }
            }
        }

        int r = hmx - hId - 1;
        String tmp = sb.substring(hId - r, hId + r);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < tmp.length(); ++ i) {
            if (tmp.charAt(i) != '#') {
                ans.append(tmp.charAt(i));
            }
        }
        return ans.toString();
    }
}