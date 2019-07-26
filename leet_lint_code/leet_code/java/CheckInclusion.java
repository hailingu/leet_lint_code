// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 567.
// Date: 2019.7.26


class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] target = new int[256];

        int i = 0;
        while (i < s1.length()) {
            target[s1.charAt(i++)]++;
        }

        int j = 0, m = 0;
        int[] memo = new int[256];

        while (m < s1.length() && j + m < s2.length()) {
            char c = s2.charAt(j + m);
            if (target[c] > 0) {
                memo[c]++;
                if (memo[c] > target[c]) {
                    int idx = j + m;
                    while (memo[c] > target[c]) {
                        memo[s2.charAt(j ++)]--;
                    }
                    m = idx - j + 1;
                } else {
                    m++;
                }
            } else if (target[c] == 0) {
                int idx = j + m;
                while (j < idx) {
                    memo[s2.charAt(j ++)]--;
                }
                j = idx + 1;
                m = 0;
            }

            if (m == s1.length()) {
                return true;
            }
        }
        return false;
    }
}