// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 370.
// Date: 2019.8.2

class GetModifiedArray {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        
        int idx = 0;
        for (; idx < updates.length; ++ idx) {
            int[] operators = updates[idx];
            int i = operators[0];
            int j = operators[1];
            ans[i] += operators[2];
            if (j < length - 1) {
                ans[j + 1] -= operators[2];
            }
        }

        int sum = 0;
        for (int i = 0; i < length; ++ i) {
            sum += ans[i];
            ans[i] = sum;
        }
        
        return ans;
    }
}