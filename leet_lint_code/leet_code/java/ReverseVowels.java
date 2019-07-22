// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 345.
// Date: 2019.7.23

class ReverseVowels {
    public String reverseVowels(String s) {
        StringBuilder ans = new StringBuilder(s);
        Set<Character> vowel = new HashSet<Character>(Arrays.asList(new Character[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}));

        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (!vowel.contains(s.charAt(i))) {
                ++ i;
                continue;
            }

            if (!vowel.contains(s.charAt(j))) {
                -- j;
                continue;
            }
            
            if (i > j) {
                break;
            }
            
            char t = s.charAt(i);
            ans.setCharAt(i, s.charAt(j));
            ans.setCharAt(j, t);
            j --;
            i ++;
        }

        return ans.toString();
    }
}