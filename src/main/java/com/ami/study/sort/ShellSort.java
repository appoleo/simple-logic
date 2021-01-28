package com.ami.study.sort;

/**
 * 希尔排序
 *
 * @author wangchendong
 * @date 2021/01/28
 */
public class ShellSort extends MySort {

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 2, 4, 1, 9, 5, 7};
        sort(arr);
        print(arr);
    }

    /**
     * O(n^1.3)
     *
     * @param arr array for sort
     */
    static void sort(int[] arr) {
        // Knuth序列
        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
        }
        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        swap(arr, j, j - gap);
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
