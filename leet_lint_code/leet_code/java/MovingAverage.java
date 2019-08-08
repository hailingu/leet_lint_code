// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 346.
// Date: 2019.8.9

import java.util.Queue;
import java.util.LinkedList;

class MovingAverage {    
    Queue<Integer> queue = new LinkedList<>();
    int sum = 0;
    int size;
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        if (queue.size() < size) {
            sum += val;
        } else {
            int head = queue.poll();
            sum += val - head;
        }
        
        queue.add(val);
        return sum / (double)queue.size();
    }
}