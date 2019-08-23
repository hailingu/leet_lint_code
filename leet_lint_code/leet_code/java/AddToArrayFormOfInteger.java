// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 989.
// Date: 2019.8.23

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> aList = new ArrayList<>();
        
        for (int a : A) {
            aList.add(a);
        }
        
        
        Collections.reverse(aList);
        List<Integer> bList = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        while (K != 0) {
            bList.add(K % 10);
            K /= 10;
        }
        
        int aIdx = 0;
        int bIdx = 0;
        int carrier = 0;
        
        while (aIdx < aList.size() && bIdx < bList.size()) {    
            int val = aList.get(aIdx) + bList.get(bIdx) + carrier;
            carrier = val / 10;
            val = val % 10;
            ans.add(val);
            
            ++ aIdx;
            ++ bIdx;
        }
        
        while (bIdx < bList.size()) {
            int val = bList.get(bIdx) + carrier;
            carrier = val / 10;
            val = val % 10;
            ans.add(val);
            ++ bIdx;
        }
        
        while (aIdx < aList.size()) {
            int val = aList.get(aIdx) + carrier;
            carrier = val / 10;
            val = val % 10;
            ans.add(val);
            ++ aIdx;
        }

        if (carrier > 0) {
            ans.add(carrier);
        }
        
        Collections.reverse(ans);
        return ans;
    }
}