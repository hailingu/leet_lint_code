// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 881.
// Date: 2019.7.11

import java.util.Arrays;

class NumRescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int ans = 0;
        int minIdx = 0;
        int maxIdx = people.length - 1;

        while (minIdx <= maxIdx) {
            ++ ans;

            if (people[minIdx] + people[maxIdx] <= limit) {
                ++ minIdx;
            } 
            -- maxIdx;
        }

        return ans;
    }
}