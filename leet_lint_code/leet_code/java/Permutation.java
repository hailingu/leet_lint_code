// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 46.
// Date: 2019.7.10

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Permutation {

    void backtrack(int n, List<Integer> nums, List<List<Integer>> output, int first) {
        if (first == n) {
            output.add(new ArrayList<>(nums));
            return;
        }

        for (int i = first; i < n; ++ i) {
            Collections.swap(nums, first, i);
            backtrack(n, nums, output, first + 1);
            Collections.swap(nums, first, i);
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new ArrayList<>(nums.length);

        for (int i : nums) {
            numsList.add(i);
        }

        List<List<Integer>> output = new ArrayList<>();
        backtrack(nums.length, numsList, output, 0);
        return output;
    }
}