// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 1013.
// Date: 2019.8.23

class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int left = 0;
        int right = 0;
        int sum = 0;
        
        for (int a : A) {
            sum += a;
        } 
        
        if (sum %3 != 0) {
            return false;
        }
        
        
        int i = 0;
        int j = A.length - 1;
        int target = sum / 3;
        
        while (i < A.length) {
            left += A[i];
            ++ i;
            
            if (left == target) {
                break;
            }
        }
        
        while (j > i) {
            right += A[j];
            -- j;
            
            if (target == right) {
                break;
            }
        }
        
        if (right != target || left != target) {
            return false;
        }
        
        return true;
    } 
}