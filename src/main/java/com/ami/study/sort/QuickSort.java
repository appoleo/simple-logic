package com.ami.study.sort;

/**
 * @author wangchendong
 * @date 2021/01/29
 */
public class QuickSort extends MySort{

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 2, 4, 1, 9, 5, 7, 10};
        sort(arr);
        print(arr);
    }

    static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) return;
        int pivot = quick(arr, leftBound, rightBound);
        quickSort(arr, leftBound, pivot - 1);
        quickSort(arr, pivot + 1, rightBound);
    }

    static int quick(int[] arr, int leftBound, int rightBound) {
        int left = leftBound;
        int right = rightBound - 1;
        int pivot = arr[rightBound];
        while (left <= right) {
            while (left <= right && arr[left] <= pivot) left++;
            while (left <= right && arr[right] > pivot) right--;
            if (left < right)swap(arr, left, right);
        }
        swap(arr, left, rightBound);
        return left;
    }
}
