// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 1119.
// Date: 2019.7.27


class RemoveVowels {
    public String removeVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); ++ i) {
            if (!vowels.contains(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}