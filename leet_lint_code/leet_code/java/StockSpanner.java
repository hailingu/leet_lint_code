// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 901.
// Date: 2019.7.9

import java.util.ArrayList;
import java.util.List;

class StockSpanner {

    class Pair {
        int val;
        int span;

        Pair(int val, int span) {
            this.val = val;
            this.span = span;
        }
    }

    List<Pair> spannerList = new ArrayList<Pair>();

    public StockSpanner() {

    }

    public int next(int price) {
        if (spannerList.size() == 0) {
            spannerList.add(new Pair(price, 1));
            return 1;
        } else {
            Pair p = spannerList.get(spannerList.size() - 1);
            if (price < p.val) {
                spannerList.add(new Pair(price, 1));
                return 1;
            } else {
                int j = spannerList.size() - 1 - p.span;
                while (j >= 0) {
                    p = spannerList.get(j);
                    if (price < p.val) {
                        break;
                    }

                    j = j - p.span;
                }
                int span = spannerList.size() - j;
                spannerList.add(new Pair(price, span));
                return span;
            }
        }
    }
}