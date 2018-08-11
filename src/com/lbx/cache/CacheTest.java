package com.lbx.cache;

import org.junit.Test;

/**
 * @date 2018/4/24 11:47
 */
public class CacheTest {
    @Test
    public void fun1() {
        LRUCache<String,String> cache=new LRUCache<String,String>(4);


        System.out.println(cache);
    }
}
