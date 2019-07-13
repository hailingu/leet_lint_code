// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 716.
// Date: 2019.7.13

import java.util.ArrayList;
import java.util.List;

class MaxStack {

    List<Integer> stack = new ArrayList<>();
    int maxIdx = 0;
    int maxVal = Integer.MIN_VALUE;

    /** initialize your data structure here. */
    public MaxStack() {

    }

    public void push(int x) {
        stack.add(x);
        if (x >= maxVal) {
            maxVal = x;
            maxIdx = stack.size() - 1;
        }
    }

    public int pop() {
        int ret = 0;
        if (maxIdx == stack.size() - 1) {
            ret = popMax();
        } else {
            ret = stack.remove(stack.size() -1);
        }
        return ret;
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int peekMax() {
        return maxVal;
    }

    public int popMax() {
        stack.remove(maxIdx);
        int ret = maxVal;
        maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < stack.size(); ++ i) {
            if (stack.get(i) >= maxVal) {
                maxIdx = i;
                maxVal = stack.get(i);
            }
        }
        return ret;
    }
}