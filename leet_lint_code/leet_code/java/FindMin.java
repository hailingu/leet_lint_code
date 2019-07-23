// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 153.
// Date: 2019.7.23

class FindMin {
    public int findMin(int[] nums) { 
        Arrays.sort(nums);
        return nums[0];
    }
}