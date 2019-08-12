// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 1078.
// Date: 2019.8.13


class OccurrencesAfterBigram  {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> ansList = new ArrayList<>();
        String[] strs = text.split(" ");
        for (int i = 0; i < strs.length; i ++) {
            int j = i + 1;
            int m = j + 1;
            
            if (j < strs.length && m < strs.length && strs[i].equals(first) && strs[j].equals(second)) {
                ansList.add(strs[m]);
            }
        }
        
        String[] ans = new String[ansList.size()];
        for (int i = 0; i < ans.length; ++ i) {
            ans[i] = ansList.get(i);
        }
        
        return ans;
    }
}