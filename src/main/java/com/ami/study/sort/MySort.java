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

    static int findMin(int[] arr) {
        int min = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[min]) min = i;
        }
        return arr[min];
    }

    static int findMax(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[max]) max = i;
        }
        return arr[max];
    }
}
