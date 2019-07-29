// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 225.
// Date: 2019.7.27

import java.util.List;
import java.util.LinkedList;

class MyStack {

    List<Integer> list = new LinkedList<>();
    
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        list.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return list.remove(list.size() - 1);
    }
    
    /** Get the top element. */
    public int top() {
        return list.get(list.size() - 1);
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.isEmpty();
    }
}
