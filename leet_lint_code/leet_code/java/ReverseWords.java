// Copyright Â© 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 151.
// Date: 2019.07.20

import java.util.Stack;

class ReverseWords {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        String[] splits = s.split(" ");
        stack.addAll(Arrays.asList(splits));
        
        StringBuilder sb = new StringBuilder();

        while (!stack.empty()) {
            String top = stack.pop();
            if (top.length() > 0) {
                sb.append(top);
                if (sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(" ");
                }
            }
        }
        
        if (sb.length() > 1)
            return sb.substring(0, sb.length() - 1);
        else {
            return "";
        }
    }
}