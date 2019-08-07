// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 339.
// Date: 2019.8.8

class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }
    
    int depthSum(List<NestedInteger> nestedList, int factor) {
        int ans = 0;
        
               
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                ans += factor * ni.getInteger();
            } else {
                ans += depthSum(ni.getList(), factor + 1);
            }
        }
        return ans;
    } 
}