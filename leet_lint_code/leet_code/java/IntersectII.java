// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 350.
// Date: 2019.7.22

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectII {

    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        List<Integer> ansList = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ++ i;
            } else if (nums2[j] < nums1[i]) {
                ++ j;
            } else {
                ansList.add(nums1[i]);
                ++ i;
                ++ j;
            }
        }

        int[] ans = new int[ansList.size()];
        for (i = 0; i < ans.length; ++ i) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }
}
