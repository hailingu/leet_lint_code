// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 42.
// Date: 2019.9.12

import java.util.Stack;

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int idx = 1;
        while (idx < height.length) {
            while (!stack.empty() && height[idx] > height[stack.peek()] ) {
                int top = stack.pop();
                if (!stack.empty()) {
                    int h = Math.min(height[idx], height[stack.peek()]) - height[top];
                    int b = idx - stack.peek() - 1;
                    ans += h * b;
                }
            }
            stack.push(idx ++);
        }

        return ans;
    }

}