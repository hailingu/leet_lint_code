// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 215.
// Date: 2019.7.11

class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
                if (nums.length == 0) {
            return -1;
        }
    
        List<Integer> numsList = new ArrayList<Integer>();
        for (int i : nums) {
            numsList.add(i);
        }
        
        Collections.sort(numsList, Collections.reverseOrder());
        
        int kth = numsList.get(0);
        if (k == 1) {
            return kth;
        }
        
        int i = 1;
        k -- ;
        while (i < numsList.size() && k > 0) {
            kth = numsList.get(i ++);
            k --;
        }
        
        return kth;
    }
}