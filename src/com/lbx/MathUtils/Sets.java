//: net/mindview/util/Sets.java
package com.lbx.MathUtils;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static javafx.scene.input.KeyCode.T;

public class Sets<T> {
    /**
     * 求并集
     *
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        result.addAll(b);
        return result;
    }

    /**
     * 交集
     *
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static <T>
    Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        result.retainAll(b);
        return result;
    }


    /**
     * 求不包含右边的元素
     *
     * @param superset
     * @param subset
     * @param <T>
     * @return
     */
    public static <T> Set<T>
    difference(Set<T> superset, Set<T> subset) {
        Set<T> result = new HashSet<T>(superset);
        result.removeAll(subset);
        return result;
    }


    /**
     * 求交集之外的东西
     *
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }



} ///:~
