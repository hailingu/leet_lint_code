// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 125.
// Date: 2019.7.8

class IsPalindromeString {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        
        s = s.toLowerCase();
        
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < s.length() && !( isDigit(s.charAt(i)) || isChar(s.charAt(i)))) {
                i ++;
            }
                   
            while (j >= 0 && !(isDigit(s.charAt(j)) || isChar(s.charAt(j)))) {
                j --;
            }
            
            if (i > j) {
                break;
            }
            
            if (s.charAt(i) == s.charAt(j)) {
                i ++;
                j --;
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
    
    boolean isChar(char ch) {
        return ch >= 'a' && ch <= 'z';
    }
}