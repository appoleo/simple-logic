package com.ami.study.sort;

import java.util.Random;

/**
 * 排序公共方法
 *
 * @author wangchendong
 * @date 2021/01/27
 */
@SuppressWarnings({"ResultOfMethodCallIgnored", "UnusedReturnValue"})
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

    /* 获取int数值的位数，方法3效率最高，其次方法2、方法4，方法1最慢 */

    static int getNumLength1(int num) {
        return (num = Math.abs(num)) == 0 ? 1 : (int) Math.log10(num) + 1;
    }

    final static int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE};

    static int getNumLength2(int num) {
        for (int i = 0; ; i++) {
            if ((num = Math.abs(num)) <= sizeTable[i]) {
                return i + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[1000000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }
        long one = System.currentTimeMillis();
        for (int i : arr) {
            getNumLength1(i);
        }
        long two = System.currentTimeMillis();
        System.out.println(two - one);
        for (int i : arr) {
            getNumLength2(i);
        }
        long three = System.currentTimeMillis();
        System.out.println(three - two);
        for (int i : arr) {
            getNumLength3(i);
        }
        long four = System.currentTimeMillis();
        System.out.println(four - three);
        for (int i : arr) {
            getNumLength4(i);
        }
        long five = System.currentTimeMillis();
        System.out.println(five - four);
    }

    static int getNumLength3(int num) {
        if ((num = Math.abs(num)) < 100000) {
            // 5 or less
            return num < 100 ? (num < 10 ? 1 : 2) : (num < 1000 ? 3 : num < 10000 ? 4 : 5);
        } else {
            // 6 or more
            return num < 10000000 ? (num < 1000000 ? 6 : 7) : (num < 100000000 ? 8 : num < 1000000000 ? 9 : 10);
        }
    }

    static int getNumLength4(int num) {
        return String.valueOf(Math.abs(num)).length();
    }
}
