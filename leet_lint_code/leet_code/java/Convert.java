// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 1134.
// Date: 2019.7.29

class Convert {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || (s != null && numRows >= s.length())) {
            return s;
        }

        StringBuilder ans = new StringBuilder();
        int totalStep = 2 * numRows - 2;
        int nextStep = 0;
        for (int i = 0; i < numRows; ++i) {
            int j = i;
            nextStep = 2 * i;
            while (j < s.length()) {
                ans.append(s.charAt(j));
                if (nextStep == 0 || nextStep == totalStep) {
                    j += totalStep;
                } else {
                    j += totalStep - nextStep;
                    nextStep = totalStep - nextStep;
                }
            }
        }
        return ans.toString();
    }
}