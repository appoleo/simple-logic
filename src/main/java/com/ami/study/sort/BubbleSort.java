package com.ami.study.sort;

/**
 * 冒泡排序
 *
 * @author wangchendong
 * @date 2021/01/27
 */
public class BubbleSort extends MySort {

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 2, 4, 1, 9, 5, 7};
        sort(arr);
        print(arr);
    }

    /**
     * O(n^2)
     *
     * @param arr array for sort
     */
    static void sort(int[] arr) {
        for (int i = arr.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 最坏情况下O(n^2)
     * 最好情况下O(n)
     *
     * @param arr array for sort
     */
    static void sortOptimize(int[] arr) {
        for (int i = arr.length - 1; i > 1; i--) {
            boolean isSwapped = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                return;
            }
        }
    }
}
