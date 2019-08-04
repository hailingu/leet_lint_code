// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 1085.
// Date: 2019.7.29


class SumOfDigits {
    public int sumOfDigits(int[] A) {
        int min = A[0];
        
        for (int i : A) {
            min = min < i ? min : i;
        }
        
        int sum = min % 10;
        min = min / 10;
        while (min > 0) {
            sum += min % 10;
            min = min / 10;
        }
         
        if (sum % 2 == 1) {
            return 0;
        }
        
        return 1;
    }
}