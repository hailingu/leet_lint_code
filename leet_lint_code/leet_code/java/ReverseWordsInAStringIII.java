// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 557.
// Date: 2019.8.25

class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }
        
        
        String[] strs = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (String str : strs) {
            if (str.length() > 0) {
                StringBuilder temp = new StringBuilder(str);
                ans.append(temp.reverse());
                ans.append(" ");  
            }
        }
        
        String ans2;
        if (ans.length() > 1) {
            ans2 = ans.substring(0, ans.length() - 1);
        } else {
            ans2 = ans.toString();
        }
        
        return ans2;
    }
}