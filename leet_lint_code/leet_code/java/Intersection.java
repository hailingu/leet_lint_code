// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 349.
// Date: 2019.7.22

class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> filter = new ArrayList<>();
            
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (filter.size() > 0 && filter.get(filter.size() - 1) == nums1[i]) {
                   // filter.add(nums1[i]);
                } else {
                    filter.add(nums1[i]);
                }
                
                i ++;
                j ++;
            } else {
                if (nums1[i] > nums2[j]) {
                   ++ j;
                } else {
                    ++ i;
                }
            }
        }
        
        int[] ans = new int[filter.size()];
        for (i = 0; i < filter.size(); ++ i) {
            ans[i] = filter.get(i);
        }
        
        return ans;
    }
}