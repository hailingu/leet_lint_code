// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 717.
// Date: 2019.8.22


class OnebitandTwobitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) {
            return true;
        }
        
        boolean ans = false;
                
        int i = 0;
        while (i < bits.length) {
            if (bits[i] == 0) {
                ++ i;
            } else {
                i += 2;
            }
            
            if (bits.length - i == 1) {
                return true;
            }
        }
        
        return ans;
    }
}