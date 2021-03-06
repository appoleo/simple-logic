package com.ami.study.sort;

/**
 * 插入排序
 *
 * @author wangchendong
 * @date 2021/01/27
 */
public class InsertionSort extends MySort {

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 2, 4, 1, 9, 5, 7};
        sort(arr);
        print(arr);
    }

    /**
     * 最坏情况下O(n^2)
     * 最好情况下O(n)
     *
     * @param arr array for sort
     */
    static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
