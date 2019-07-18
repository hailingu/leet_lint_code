// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 41.
// Date: 2019.7.18


class  FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        for (; i < nums.length; ++ i) {
            if (nums[i] == 1) {
                break;
            }
        }

        if (i == nums.length) {
            return 1;
        }


        int[] sgn = new int[nums.length + 1];

        for (i = 0; i < nums.length; ++ i) {
            if (nums[i] < sgn.length) {
                sgn[nums[i]] = 1;
            }
        }

        for (i = 1; i < sgn.length; ++ i) {
            if (sgn[i] != 1) {
                break;
            }
        }

        return i;
    }

    public static void main (String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int ans = firstMissingPositive.firstMissingPositive(new int[] {3,4, -1, 1});
        System.out.println(ans);
    }
}