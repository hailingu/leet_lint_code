// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 31 .
// Date: 2019.8.27

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i >= 1 && nums[i - 1] >= nums[i]) -- i;
        if (i == 0) {
            Arrays.sort(nums);
            return ;
        }

        List<Integer> permutationList = new ArrayList<>();
        int j = nums.length - 1;
        while (j > i && nums[j] <= nums[i - 1]) -- j;

        int p = i - 1;
        while (p < nums.length) {
            if (p != j) {
                permutationList.add(nums[p]);
            }
            ++ p;
        }

        nums[i - 1] = nums[j];
        Collections.sort(permutationList);
        p = 0;
        while (p < permutationList.size()) {
            nums[i + p] = permutationList.get(p);
            ++ p;
        }
    }
}
