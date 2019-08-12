// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 254.
// Date: 2019.8.13

class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        if (n == 1) {
            return ans;
        }

        List<Integer> tmp = new ArrayList<>();

        backtrack(n, ans, tmp, n);
        return ans;
    }

    void backtrack(int n, List<List<Integer>> ans, List<Integer> tmp, int target) {
        if (n == 1) {
            ans.add(tmp);
            return;
        }

        if (n == 2) {
            tmp.add(n);
            if (tmp.size() > 1) {
                ans.add(tmp);
            }
            return;
        }

        int i ;

        if (n != target) {
            i = n;
        } else {
            i = n / 2;
        }

        for (; i >= 2; i--) {
            if (n % i == 0) {
                List<Integer> tmp2 = new LinkedList<>(tmp);
                if (tmp2.size() == 0 || i <= tmp2.get(tmp2.size() - 1)) {
                    tmp2.add(i);
                    backtrack(n / i, ans, tmp2, n);
                }
            }
        }
    }
}