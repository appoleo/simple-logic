package com.ami.study.sort;

/**
 * 归并排序
 *
 * @author wangchendong
 * @date 2021/01/28
 */
public class MergeSort extends MySort {

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 2, 4, 1, 9, 5, 7};
        sort(arr);
        print(arr);
    }

    static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 时间复杂度O(N*LogN)
     * 空间复杂度O(N)
     *
     * @param arr   array to sort
     * @param left  left bound
     * @param right right bound
     */
    static void mergeSort(int[] arr, int left, int right) {
        if (left == right) return;
        int mid = left + (right - left) / 2;
        // 左边排序
        mergeSort(arr, left, mid);
        // 右边排序
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid + 1, right);
    }

    /**
     * 对前后两部分分别有序的数组排序
     *
     * @param arr        eg: {1, 4, 5, 9, 2, 3, 7}
     * @param leftPtr    前半部分起点 eg: 0
     * @param rightPtr   后半部分起点 eg: 4
     * @param rightBound 右边界 eg: 6
     */
    static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound) {
        int[] temp = new int[rightBound - leftPtr + 1];
        int i = leftPtr;
        int j = rightPtr;
        int k = 0;
        while (i <= rightPtr - 1 && j <= rightBound) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= rightPtr - 1) {
            temp[k++] = arr[i++];
        }
        while (j <= rightBound) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, leftPtr, temp.length);
    }
}
