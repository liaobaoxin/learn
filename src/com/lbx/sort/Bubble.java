package com.lbx.sort;

import java.util.Arrays;

/**
 * @date 2018/4/24 14:28
 */
public class Bubble {
    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 6, 4, 5, 2, 6, 7, 1};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j =0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
