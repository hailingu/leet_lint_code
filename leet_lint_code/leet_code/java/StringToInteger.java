// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 8.
// Date: 2019.7.8


class StringToInteger {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        long lower = 2147483648L;
        long upper = 2147483647L;

        int n = 0;
        int i = 0;
        while (i < str.length() && ' ' == str.charAt(i)) {
            i ++;
        }

        int sign = 1;
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            if (str.charAt(i) == '-') {
                sign = -1;
            }
            ++ i;
        }

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            int c = str.charAt(i) - '0';

            if (sign > 0 && (n > upper / 10 || (n == upper / 10 && c > upper % 10))) {
                n = Integer.MAX_VALUE;
                break;
            } else if (sign < 0 && (n > lower / 10 || (n == lower / 10 && c > lower % 10))) {
                n = Integer.MIN_VALUE;
                break;
            }

            n = n * 10 + c;
            ++ i;
        }
        return sign > 0 ? n : -n;
    }
    
}