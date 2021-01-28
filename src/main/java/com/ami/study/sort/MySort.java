package com.ami.study.sort;

/**
 * 排序公共方法
 *
 * @author wangchendong
 * @date 2021/01/27
 */
public class MySort {

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void print(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}
