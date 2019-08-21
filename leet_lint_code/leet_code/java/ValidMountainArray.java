// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 941.
// Date: 2019.8.21

class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        
        int i = 0;
        int j = A.length - 1;
        while (i < A.length - 1 && A[i] < A[i + 1]) {++ i;}
        while (j >= 1 && A[j] < A[j - 1]) { -- j;}
        return i == j && i != A.length - 1 && j != 0;
    }
}