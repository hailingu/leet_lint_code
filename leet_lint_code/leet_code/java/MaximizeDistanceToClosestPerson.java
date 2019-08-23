// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 849.
// Date: 2019.8.23

class MaximizeDistanceToClosestPerson{
    public int maxDistToClosest(int[] seats) {
        int ans = 0;
        for (int i = 0; i < seats.length; ++ i) {
          if (seats[i] == 0) {
            int left = i;
            int right = i;
            while (left >= 0 && seats[left] == 0) -- left;
            while (right < seats.length && seats[right] == 0) ++ right;
            
            if (i == 0) {
              ans = Math.max(ans, right - i);
            } else if (i == seats.length - 1) {
              ans = Math.max(ans, i - left);
            } else {
              ans = Math.max(ans, Math.min(i - left, right - i));
            }
            
          }
        }
        return ans;
    }
}