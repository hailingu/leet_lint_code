// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 974.
// Date: 2019.7.18

class SubarraysDivByK {
    public int subarraysDivByK(int[] nums, int K) {
        if (nums.length < 1) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            sum += num;
            int residual = sum % K;
            
            if (residual == 0) {
                ans ++;
            }
            
           if (residual < 0) {
                residual += K;
            }
            
            if (map.containsKey(residual)) {
                int cnt = map.get(residual);
                ans += cnt;
                map.put(residual, cnt + 1);
            } else {
                map.put(residual, 1);
            }
        }
        
        return ans;
    }
}