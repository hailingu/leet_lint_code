// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 66.
// Date: 2019.7.16

class PlusOne {
    public int[] plusOne(int[] digits) {
        int carrier = 0;
        int sum = digits[digits.length - 1] + 1;
        carrier = sum / 10;
        digits[digits.length - 1] = sum % 10;
        
        for (int i = digits.length - 2; i > -1; -- i) {
            if (carrier > 0) {
                sum = digits[i] + carrier;
                carrier = sum / 10;
                digits[i] = sum % 10;
            }
        }
        
        int[] ans;
        int i = 0;
        if (carrier != 0) {
            ans = new int[digits.length + 1];  
            ans[0] = carrier;
            i ++ ;
        } else {
            ans = new int[digits.length];
        }
        
        int j = 0;
        while (j < digits.length) {
            ans[i ++] = digits[j ++];
        }
        
        return ans;
    }
}