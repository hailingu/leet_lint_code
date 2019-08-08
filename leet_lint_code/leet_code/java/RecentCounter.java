// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 933.
// Date: 2019.8.9


import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> queue = new LinkedList<>();

    public RecentCounter() {
    }

    public int ping(int t) {
        this.queue.add(t);

        while (queue.size() != 0) {
            int head = this.queue.peek();
            if (t - head > 3000) {
                this.queue.poll();
            } else {
                break;
            }
        }

        return this.queue.size();
    }
}
