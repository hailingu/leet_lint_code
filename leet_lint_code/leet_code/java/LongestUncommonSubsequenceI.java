// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 521.
// Date: 2019.8.19

class LongestUncommonSubsequenceI  {
    public int findLUSlength(String a, String b) {
        if (a == null && b == null) {
            return -1;
        } else if (a != null && b == null) {
            return a.length();
        } else if (a == null && b != null) {
            return b.length();
        } else {
            if (a.equals(b)) {
                return -1;
            } else {
                return Math.max(a.length(), b.length());
            }
        }
    }
}