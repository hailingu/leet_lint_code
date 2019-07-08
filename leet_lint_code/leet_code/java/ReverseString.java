// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 344.
// Date: 2019.7.7

class ReverseString {
    public void reverseString(char[] s) {
        reverse(s, 0, s.length-1);
    }
    
    public void reverse(char[] s, int from, int to) {
        while (from < to) {
            char t = s[from];
            s[from ++] = s[to];
            s[to --] = t;
        }
    }
}