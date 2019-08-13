// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 22.
// Date: 2019.8.13


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        StringBuilder init = new StringBuilder();
        Set<String> filter = new HashSet<>();
        backtrack(0, filter, init, n);
        List<String> ans = new ArrayList<>(filter);
        return ans;
    }

    void backtrack(int start, Set<String> ans, StringBuilder tmp, int level) {
        if (start == level) {
            ans.add(tmp.toString());
            return;
        }


        for (int i = 0; i <= start; ++i) {
            StringBuilder t = new StringBuilder(tmp);
            t.insert(i, "()");
            backtrack(start + 1, ans, t, level);
        }
    }
}