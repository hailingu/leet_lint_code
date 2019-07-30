// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 232.
// Date: 2019.7.31

class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.add(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!s2.isEmpty()) {
            return s2.pop();
        }
        
        while (!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        
        while (!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s2.isEmpty() && s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */