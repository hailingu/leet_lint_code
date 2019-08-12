// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 223.
// Date: 2019.8.12


class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int ans;

        Range x1 = new Range(A, C);
        Range x2 = new Range(E, G);

        Range y1 = new Range(B, D);
        Range y2 = new Range(F, H);

        Range x1x2 = x1.intersection(x2);
        Range y1y2 = y1.intersection(y2);

        ans = (x1.right - x1.left) * (y1.right - y1.left) +
                (x2.right - x2.left) * (y2.right - y2.left) -
                (x1x2.right - x1x2.left ) * (y1y2.right - y1y2.left);

        return ans;
    }
}

class Range {
    int left;
    int right;

    Range(int left, int right) {
        this.left = left;
        this.right = right;
    }

    Range intersection(Range range) {
        int left = Math.max(this.left, range.left);
        int right = Math.min(this.right, range.right);
        if (left > right) {
            left = 0;
            right = 0;
        }
        return new Range(left, right);
    }
}
