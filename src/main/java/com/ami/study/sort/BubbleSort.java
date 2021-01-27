package com.ami.study.sort;

/**
 * @author wangchendong
 * @date 2021/01/27
 */
public class BubbleSort extends MySort {

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 2, 4, 1, 9, 5, 7};
        sort(arr);
        print(arr);
    }

    static void sort(int[] arr) {
        for (int i = arr.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}
