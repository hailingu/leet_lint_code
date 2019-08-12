// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 229.
// Date: 2019.8.12


import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int ans1 = 0;
        int cnt1 = 0;

        int ans2 = 0;
        int cnt2 = 0;

        for (int num : nums) {
            if (cnt1 == 0 && num != ans2) {
                ans1 = num;
                cnt1++;
            } else if (ans1 == num) {
                ++cnt1;
            } else if (cnt2 == 0){
                ans2 = num;
                cnt2 ++;
            }else if (ans2 == num) {
                ++cnt2;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == ans1) {
                ++cnt1;
            } else if (num == ans2) {
                ++cnt2;
            }
        }

        if (cnt1 > nums.length / 3) {
            ans.add(ans1);
        }

        if (cnt2 > nums.length / 3) {
            ans.add(ans2);
        }

        return ans;
    }
}
