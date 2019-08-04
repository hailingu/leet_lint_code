// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 20.
// Date: 2019.8.2

import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            }

            else if (s.charAt(i) == '[') {
                stack.push('[');
            }

            else if (s.charAt(i) == '{') {
                stack.push('{');
            } else if (s.charAt(i) == ')') {
                if (stack.size() == 0 || stack.peek() != '(') {
                    return false;
                }

                stack.pop();
            } else if (s.charAt(i) == ']') {

                if (stack.size() == 0 || stack.peek() != '[') {
                    return false;
                }

                stack.pop();
            } else if (s.charAt(i) == '}') {
                if (stack.size() == 0 || stack.peek() != '{') {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.size() == 0.;
    }
}