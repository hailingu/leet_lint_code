// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 460.
// Date: 2019.7.18

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;


class LFUCache {
    
    class HitInfo implements Comparable<HitInfo>{
        int time;
        int cnt;
        int key;

        HitInfo (int time, int cnt, int key) {
            this.time = time;
            this.cnt = cnt;
            this.key = key;
        }

        @Override
        public int compareTo(HitInfo o) {
            int compare = Integer.compare(this.cnt, o.cnt);
            return compare == 0 ? Long.compare(this.time, o.time) : compare;
        }
    }

    private Map<Integer, Integer> cache;
    private Map<Integer, HitInfo> itemInfo;

    private int capacity;
    private int time = 0;

    public LFUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.itemInfo = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = -1;
        if (this.capacity == 0) {
            return value;
        }
        
        if (cache.containsKey(key)) {
            value = cache.get(key);
            HitInfo hitInfo = itemInfo.get(key);
            hitInfo.cnt ++ ;
            hitInfo.time = this.time;
        }

        this.time ++ ;
        return value;
    }

    public void put(int key, int value) {
        if (this.capacity == 0) {
            return;
        }

        if (!cache.containsKey(key)) {
            if (capacity == cache.size()) {
                HitInfo min = Collections.min(itemInfo.values());
                cache.remove(min.key);
                itemInfo.remove(min.key);
            }
            
            HitInfo hitInfo = new HitInfo(this.time, 1, key);
            itemInfo.put(key, hitInfo);
        } else {    
            HitInfo hitInfo = itemInfo.get(key);
            hitInfo.time = this.time;
            hitInfo.cnt ++;
        }
        
        cache.put(key, value);
        this.time ++ ;
    }
}
