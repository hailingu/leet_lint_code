// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 59.
// Date: 2019.8.27

import java.util.*;

class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<point> list = new ArrayList<>();
        list.add(new point(p1));
        list.add(new point(p2));
        list.add(new point(p3));
        list.add(new point(p4));

        Collections.sort(list, new Comparator<point>() {
            @Override
            public int compare(point p1, point p2) {

                if (p1.x > p2.x) {
                    return 1;
                } else if (p1.x == p2.x && p1.y > p2.y) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        point normalP1P4 = new point(list.get(3).x - list.get(0).x, list.get(3).y - list.get(0).y);
        point normalP2P3 = new point(list.get(2).x - list.get(1).x, list.get(2).y - list.get(1).y);

        int factor = normalP1P4.x * normalP2P3.x + normalP1P4.y * normalP2P3.y;
        if (factor != 0) {
            return false;
        }
        
        int factorLength = normalP2P3.x * normalP2P3.x + normalP2P3.y * normalP2P3.y;
        if (factorLength == 0) {
            return false;
        }
        
        int factorLength2 =  normalP1P4.x *  normalP1P4.x +  normalP1P4.y *  normalP1P4.y;
        if (factorLength2 != factorLength) {
            return false;
        }
        
        double dist1 = list.get(0).dist(list.get(1));
        double dist2 = list.get(0).dist(list.get(3));
        if (dist2 != 2 * dist1) {
            return false;
        }

        return true;
    }
}

class point {
    int x;
    int y;
    
    point(int[] p) {
        this.x = p[0];
        this.y = p[1];
    }
    
    point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    double dist(point b) {
        double l = this.x - b.x;
        double h = this.y - b.y;
        return l * l + h * h;
    }
    
}