// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 655.
// Date: 2019.8.1

class CheckPossibility {
    public boolean checkPossibility(int[] nums) {
        int i = 0;
        while (i < nums.length - 1 && nums[i] <= nums[i + 1]) {
            ++i;
        }

        
        if (i == nums.length - 1) {
            return true;
        }
        
        int possible1 = nums[i];
        int possible2 = nums[i + 1];

        return checkPossibilityHelp(nums, possible1, i + 1) || checkPossibilityHelp(nums, possible2, i);
    }

    boolean checkPossibilityHelp(int[] nums, int replace, int i) {
        int origin = nums[i];
        nums[i] = replace;
        for (int j = 0; j < nums.length - 1; j ++) {
            if (nums[j] > nums[j + 1]) {
                nums[i] = origin;
                return false;
            }
        }

        return true;
    }
}