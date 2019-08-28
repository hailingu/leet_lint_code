// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 954.
// Date: 2019.8.28

import java.util.Arrays;
import java.util.HashMap;

public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] A) {
        if (A.length == 0) {
            return true;
        }

        Arrays.sort(A);
        HashMap<Integer, Integer> map = new HashMap<>();
        int zeros = 0;
        for (int a : A) {
            if (a != 0) {
                map.put(a, map.getOrDefault(a, 0) + 1);
            } else {
                ++ zeros;
            }
        }

        if (zeros % 2 == 1) {
            return false;
        }

        for (int a : A) {
            if (a == 0) {
                continue;
            }

            if (map.containsKey(a)) {
                if (map.containsKey(2 * a)) {
                    int val = map.get(a);
                    val --;
                    if (val == 0) {
                        map.remove(a);
                    } else {
                        map.put(a, val);
                    }

                    val = map.get(2 * a);
                    val --;
                    if (val == 0) {
                        map.remove(2 * a);
                    } else {
                        map.put(2 * a , val);
                    }
                } else if (map.containsKey(a / 2)){
                    int val = map.get(a);
                    val --;
                    if (val == 0) {
                        map.remove(a);
                    } else {
                        map.put(a, val);
                    }

                    val = map.get(a / 2);
                    val --;
                    if (val == 0) {
                        map.remove(a / 2);
                    } else {
                        map.put(a / 2 , val);
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
