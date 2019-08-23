// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 1002.
// Date: 2019.8.24

class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        
        List<String> ans = new ArrayList<>();
        if (A.length == 0) {
            return ans;
        }
        
        int[][] dict = new int[A.length][192];
        
      //  HashMap<Character, Integer> map = new HashMap<>();
        
        int n = 0;
        for (String a : A) {
            char[] cc = a.toCharArray();
            for (char c : cc) {
                dict[n][c] ++;
            }
            
            ++ n;
        }
        
        for (int i = 0; i < 192; ++ i) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < A.length; ++ j) {
                if (dict[j][i] == 0) {
                    min = 0;
                    break;
                }
                
                min = Math.min(dict[j][i], min);
            }
            
            int m = 0;
            while (m < min && min != Integer.MAX_VALUE) {
                char c = (char)i;
                ans.add(String.valueOf(c));
                ++ m;
            }
        }
        
        return ans;
    }
}