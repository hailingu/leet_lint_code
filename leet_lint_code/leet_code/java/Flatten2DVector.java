// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 251.
// Date: 2019.8.12


class Vector2D {

    List<Integer> list = new ArrayList<>();
    int idx = -1;
    public Vector2D(int[][] v) {
        for (int i = 0; i < v.length; ++ i) {
            for (int j = 0; j < v[i].length; ++ j) {
                list.add(v[i][j]);
            }
        }
        idx = 0;
    }
    
    public int next() {
        return list.get(idx ++);
    }
    
    public boolean hasNext() {
        return idx < list.size() && idx != -1;
    }
}
