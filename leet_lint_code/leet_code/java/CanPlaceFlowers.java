// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 605.
// Date: 2019.8.23

class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
      
        if (flowerbed.length == 1 && n == 1 && flowerbed[0] == 0) {
          return true;
        }
      
        int i = 0;
        int cnt = 0;
        while (i < flowerbed.length && cnt < n) {
          // find first place to plant
          if (flowerbed[i] == 0) {
            int left = i - 1;
            int right = i + 1;
            
            if (i == 0) {
              if (right < flowerbed.length && flowerbed[right] == 0) {
                flowerbed[i] = 1;
                ++ cnt;
              }
            } else if (i == flowerbed.length - 1) {
              if (left >= 0 && flowerbed[left] == 0) {
                flowerbed[i] = 1;
                ++ cnt;
              }
            } else {
              if (flowerbed[left] == 0 && flowerbed[right] == 0) {
                flowerbed[i] = 1;
                ++ cnt;
              }
            }
          }
        
          ++ i;
        }
        return cnt == n;
    }
}