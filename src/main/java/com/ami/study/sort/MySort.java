package com.ami.study.sort;

import java.util.Random;

/**
 * 排序公共方法
 *
 * @author wangchendong
 * @date 2021/01/27
 */
@SuppressWarnings({"ResultOfMethodCallIgnored", "UnusedReturnValue", "unused"})
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
            getNumLength3(i);
        }
        long two = System.currentTimeMillis();
        System.out.println(two - one);
        for (int i : arr) {
            getNumLength2(i);
        }
        long three = System.currentTimeMillis();
        System.out.println(three - two);
        for (int i : arr) {
            getNumLength1(i);
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
        if (num < 100000) {
            // 5 or less
            if (num < 100) {
                // 1 or 2
                if (num < 10)
                    return 1;
                else
                    return 2;
            } else {
                // 3 or 4 or 5
                if (num < 1000)
                    return 3;
                else {
                    // 4 or 5
                    if (num < 10000)
                        return 4;
                    else
                        return 5;
                }
            }
        } else {
            // 6 or more
            if (num < 10000000) {
                // 6 or 7
                if (num < 1000000)
                    return 6;
                else
                    return 7;
            } else {
                // 8 to 10
                if (num < 100000000)
                    return 8;
                else {
                    // 9 or 10
                    if (num < 1000000000)
                        return 9;
                    else
                        return 10;
                }
            }
        }
    }

    static int getNumLength4(int num) {
        return String.valueOf(Math.abs(num)).length();
    }

    public static int numberOfDigits(long num) {
        // Guessing 4-digit numbers will be more probable.
        // They are set in the first branch.
        if (num < 10000L) { // from 1 to 4
            if (num < 100L) { // 1 or 2
                if (num < 10L) {
                    return 1;
                } else {
                    return 2;
                }
            } else { // 3 or 4
                if (num < 1000L) {
                    return 3;
                } else {
                    return 4;
                }
            }
        } else { // from 5 a 20 (albeit longs can't have more than 18 or 19)
            if (num < 1000000000000L) { // from 5 to 12
                if (num < 100000000L) { // from 5 to 8
                    if (num < 1000000L) { // 5 or 6
                        if (num < 100000L) {
                            return 5;
                        } else {
                            return 6;
                        }
                    } else { // 7 u 8
                        if (num < 10000000L) {
                            return 7;
                        } else {
                            return 8;
                        }
                    }
                } else { // from 9 to 12
                    if (num < 10000000000L) { // 9 or 10
                        if (num < 1000000000L) {
                            return 9;
                        } else {
                            return 10;
                        }
                    } else { // 11 or 12
                        if (num < 100000000000L) {
                            return 11;
                        } else {
                            return 12;
                        }
                    }
                }
            } else { // from 13 to ... (18 or 20)
                if (num < 10000000000000000L) { // from 13 to 16
                    if (num < 100000000000000L) { // 13 or 14
                        if (num < 10000000000000L) {
                            return 13;
                        } else {
                            return 14;
                        }
                    } else { // 15 or 16
                        if (num < 1000000000000000L) {
                            return 15;
                        } else {
                            return 16;
                        }
                    }
                } else { // from 17 to ...¿20?
                    if (num < 1000000000000000000L) { // 17 or 18
                        if (num < 100000000000000000L) {
                            return 17;
                        } else {
                            return 18;
                        }
                    } else { // 19? Can it be?
                        // 10000000000000000000L isn't a valid long.
                        return 19;
                    }
                }
            }
        }
    }
}
