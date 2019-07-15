// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 128.
// Date: 2019.7.15

class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> finded = new HashSet<>();
        
        for (int n : nums) {
            set.add(n);
        }
        
        int max = 0;
        for (int i = 0; i < nums.length; ++ i) {
            int temp = 1;
            if (finded.contains(nums[i])) {
                continue;
            } else {
                int t = nums[i] - 1;
                while (set.contains(t)) {
                    finded.add(t);
                    t --;
                    temp ++;
                }
            }
            max = max > temp ? max : temp;
        }
        
        return max;
    }
}