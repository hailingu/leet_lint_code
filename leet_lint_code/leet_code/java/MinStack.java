// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 155.
// Date: 2019.7.23

class MinStack {

    List<Integer> stack = new ArrayList<>();
    int minIdx = 0;
    int minVal = Integer.MAX_VALUE;
    
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        stack.add(x);
        if (x <= minVal) {
            minVal = x;
            minIdx = stack.size() - 1;
        }
    }
    
    public void pop() {
        if (minIdx == stack.size() - 1) {
          popMin();
        } else {
           stack.remove(stack.size() -1);
        }
    }
    
    public int top() {
        return stack.get(stack.size() - 1);
    }
    
    public int getMin() {
        return minVal;
    }
    
    public int popMin() {
        stack.remove(minIdx);
        int ret = minVal;
        minVal = Integer.MAX_VALUE;
        for (int i = 0; i < stack.size(); ++ i) {
            if (stack.get(i) <= minVal) {
                minIdx = i;
                minVal = stack.get(i);
            }
        }
        return ret;
    }
}