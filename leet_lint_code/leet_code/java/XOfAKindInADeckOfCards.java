// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 914.
// Date: 2019.8.22

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class XOfAKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
      if (deck.length < 2) {
        return false;
      }
      
      Arrays.sort(deck);
      Map<Integer, Integer> map = new HashMap<>();
      for (int a : deck) {
        if (map.containsKey(a)) {
          map.put(a, map.get(a) + 1);
        } else {
          map.put(a, 1);
        }
      }
      
      int gcdNumber = 0;
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
         if (gcdNumber == 0) {
           gcdNumber = entry.getValue();
         } else {
           gcdNumber = gcd(gcdNumber, entry.getValue());
         }
      }
      
      return gcdNumber != 1;
    }
  
    int gcd(int a,int b){
        while(b != 0){      
            int temp = a % b ;
            a = b ;
            b = temp ;
        }
        return a ;
    }
}