// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 88.
// Date: 2019.8.21

class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        int i = 0;
        int j = 0;
        int idx = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                ans[idx++] = nums1[i++];
            } else {
                ans[idx++] = nums2[j++];
            }
        }
        
        while (i < m) {
            ans[idx++] = nums1[i++];
        }
        
        while (j < n) {
            ans[idx++] = nums2[j++];
        }
        
        for (idx = 0; idx < m + n; ++ idx) {
            nums1[idx] = ans[idx];
        } 
    }
}