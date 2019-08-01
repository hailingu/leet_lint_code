// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 655.
// Date: 2019.8.1

class CheckPossibility {
    public boolean checkPossibility(int[] nums) {
        int i = 0;
        
        if (nums.length <= 2) {
            return true;
        }

        while (i < nums.length - 1) {
            if (nums[i] <= nums[i + 1]) {
                ++ i;
            } else {
                int diffJ = i + 1;
                while (diffJ < nums.length - 1) {
                    if (nums[diffJ] > nums[diffJ + 1]) {
                        break;
                    }
                    ++ diffJ;
                }
                
                
                if (diffJ != nums.length - 1) {
                    return false;
                }

                boolean caseTwo = true;
                if (i + 2 < nums.length) {
                    caseTwo = nums[i] <= nums[i + 2];
                }

                boolean caseOne = true;
                if (i >= 1) {
                    caseOne = nums[i + 1] >= nums[i -1];
                }

                return caseOne || caseTwo;
            }
        }
        return true;
    }
}