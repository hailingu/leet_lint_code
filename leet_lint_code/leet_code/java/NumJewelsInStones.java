// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 771.
// Date: 2019.7.28

class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> filter = new HashSet<>();
        
        for (int i = 0; i < J.length(); ++ i) {
            filter.add(J.charAt(i));
        }
        
        int cnt = 0;
        for (int i = 0; i < S.length(); ++ i) {
            if (filter.contains(S.charAt(i))) {
                cnt ++;
            }
        }
        
        return cnt;
    }
}