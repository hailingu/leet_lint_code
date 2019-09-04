// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 394.
// Date: 2019.9.4


class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        
        return decode(s).toString();
    }

    StringBuilder decode(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        StringBuilder ans = new StringBuilder();
        int idx = 0;

        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (c > '0' && c <= '9') {
                while (idx < s.length() && s.charAt(idx) != '[') ++ idx;
                int repeated = Integer.parseInt(s.substring(0, idx));
                int leftBraces = 1;
                int j = idx + 1;
                while (leftBraces > 0) {
                    if (s.charAt(j) == ']') {
                        -- leftBraces;
                    }

                    if (s.charAt(j) == '[') {
                        ++ leftBraces;
                    }

                    ++ j;
                }

                while (repeated > 0) {
                    ans.append(decode(s.substring(idx + 1, j - 1)));
                    -- repeated;
                }

                if (j < s.length()) {
                    ans.append(decode(s.substring(j)));
                    j = s.length();
                }

                idx = j;
            } else {
                c = s.charAt(idx);
                while (idx < s.length() && isChar(c)) {
                    ans.append(c);
                    ++ idx;
                    if (idx < s.length()) {
                        c = s.charAt(idx);
                    }
                }

                if (idx < s.length()) {
                    ans.append(decode(s.substring(idx)));
                    idx = s.length();
                }
            }
        }
        return ans;
    }

    boolean isChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}