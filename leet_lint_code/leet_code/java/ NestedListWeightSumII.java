// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 364.
// Date: 2019.8.7

class NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Integer> levelSum = new ArrayList<>();
        depthSumInverse(nestedList, levelSum, 1);
        int l = levelSum.size();
        int ans = 0;
        for (int sum : levelSum) {
            ans += l * sum;
            l --;
        }
        
        return ans;
    }
    
    void depthSumInverse(List<NestedInteger> nestedList, List<Integer> levelSum, int level) {
        if (levelSum.size() < level) {
            levelSum.add(0);
        }
        
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                int tmp = levelSum.get(level - 1) + ni.getInteger();
                levelSum.set(level - 1, tmp);
            } else {
                depthSumInverse(ni.getList(), levelSum, level + 1);
            }
        }
        
        return;
    }
}