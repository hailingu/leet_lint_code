// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 146.
// Date: 2019.7.19

import java.util.Map;
import java.util.LinkedHashMap;

class LRUCache {
    Cache<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new Cache(capacity, 1, true);
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (cache.capacity == 0) {
            return ;
        }    
        cache.put(key, value);
    }
}

class Cache<K,V> extends LinkedHashMap<K,V> implements Map<K, V> {
    public int capacity = -1;
    
    public Cache(int capacity,
                 float loadFactor,
                 boolean accessOrder) {
        super(capacity, loadFactor, accessOrder);
        this.capacity = capacity;
    }
    
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        // TODO Auto-generated method stub
        if(size() > this.capacity){
            return true;
        }
        return false;
    }
}
