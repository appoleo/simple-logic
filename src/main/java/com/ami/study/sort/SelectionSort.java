package com.ami.study.sort;

/**
 * 选择排序
 *
 * @author wangchendong
 * @date 2021/01/27
 */
public class SelectionSort extends MySort {

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 2, 4, 1, 9, 5, 7};
        sortOptimize(arr);
        print(arr);
    }

    static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[minPos] > arr[j + 1]) {
                    minPos = j + 1;
                }
            }
            swap(arr, i, minPos);
        }
    }

    static void sortOptimize(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int minPos = i;
            int maxPos = arr.length - 1 - i;
            for (int j = i; j < arr.length - 1 - i; j++) {
                if (arr[minPos] > arr[j + 1]) {
                    minPos = j + 1;
                }
                if (arr[arr.length - 2 - j] > arr[maxPos]) {
                    maxPos = arr.length - 2 - j;
                }
            }
            swap(arr, i, minPos);
            if (maxPos == i) {
                maxPos = minPos;
            }
            swap(arr, maxPos, arr.length - 1 - i);
        }
    }
}
