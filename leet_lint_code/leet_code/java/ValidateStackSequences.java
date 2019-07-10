// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 946.
// Date: 2019.7.10

import java.util.Stack;

public class ValidateStackSequences {
    boolean validateStackSequences(int[] pushed, int[] popped) {

        if (pushed.length == 0) {
            return true;
        }

        if (pushed.length != popped.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();

        int poppedIdx = 0;
        int stackIdx = 0;

        while (poppedIdx != popped.length) {
            if (!stack.empty() && popped[poppedIdx] == stack.peek()) {
                stack.pop();
                poppedIdx++;
            } else {
                if (stackIdx < pushed.length) {
                    stack.push(pushed[stackIdx++]);
                } else {
                    break;
                }
            }
        }

        return poppedIdx == popped.length;
    }
}
