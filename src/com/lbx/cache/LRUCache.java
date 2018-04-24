package com.lbx.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @date 2018/4/24 11:31
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    Integer MaxcacheSize;

    public LRUCache(int cacheSize) {
        super(cacheSize, 0.75f, true);
        this.MaxcacheSize = cacheSize;
    }



    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MaxcacheSize;
    }

}
