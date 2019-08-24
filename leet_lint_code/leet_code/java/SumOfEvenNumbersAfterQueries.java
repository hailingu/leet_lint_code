// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 985 .
// Date: 2019.8.23


class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        for (int a : A) {
            if (a %2 == 0) {
                sum += a;
            }
        }
        
        int[] ans = new int[queries.length];
        
        for (int i = 0; i < queries.length;  ++ i) {
            int[] query = queries[i];
            int origin = A[query[1]];
            int update = origin + query[0];
            
            int originResidual = origin %2;
            int updateResidual = update %2;
            
            if (originResidual < 0) {
                originResidual += 2;
            }
            
            if (updateResidual < 0) {
                updateResidual += 2;
            }
            
            if (originResidual == 1 && updateResidual == 0) {
                sum += update;
            } else if (originResidual == 0 && updateResidual == 1) {
                sum -= origin;
            } else if (originResidual == 0 && updateResidual == 0) {
                sum += query[0];
            } else {
                
            }
            
            A[query[1]] += query[0];
            ans[i] = sum;
        }
        
        return ans;
    }
}