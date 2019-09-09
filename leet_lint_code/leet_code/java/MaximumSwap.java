// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 670.
// Date: 2019.9.9

class MaximumSwap {
    public int maximumSwap(int num) {
        if (num == 0) {
            return num;
        }

        List<Integer> list = new ArrayList<Integer>();
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }

        int[] nums = new int[list.size()];
        Collections.reverse(list);
        int idx = 0;
        while (idx < nums.length) {
            nums[idx] = list.get(idx++);
        }

        int i = 0;
        while (i < nums.length) {
            int j = i + 1;
            int pivot = nums[i];
            int pivotIdx = i;
            while (j < nums.length) {
                if (nums[j] >= pivot) {
                    pivot = nums[j];
                    pivotIdx = j;
                }

                ++ j;
            }
            
            if (nums[pivotIdx] != nums[i]) {
                int t = nums[pivotIdx];
                nums[pivotIdx] = nums[i];
                nums[i] = t;
                break;
            }
            
            ++ i;
        }

        int ans = 0;
        for (int q : nums) {
            ans = ans * 10 + q;
        }
        return ans;
    }

}