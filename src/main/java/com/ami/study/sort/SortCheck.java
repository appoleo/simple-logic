package com.ami.study.sort;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.util.Arrays;
import java.util.Random;

/**
 * 排序检测
 *
 * @author wangchendong
 * @date 2021/01/27
 */
public class SortCheck {

    /**
     * 数据量级
     */
    private static final int MAGNITUDE = 100000;

    public static void main(String[] args) {
        int[] arr = getRandomArr();
        int[] arrCopy = new int[arr.length];
        System.arraycopy(arr, 0, arrCopy, 0, arr.length);
        // SelectionSort.sort(arr);
        // BubbleSort.sort(arr);
        // BubbleSort.sortOptimize(arr);
        // InsertionSort.sort(arr);
        // ShellSort.sort(arr);
        MergeSort.sort(arr);

        Arrays.sort(arrCopy);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arrCopy[i]) {
                System.out.println("Algorithm is wrong");
                return;
            }
        }
        System.out.println("Algorithm is correct");
    }

    private static int[] getRandomArr() {
        int[] arr = new int[MAGNITUDE];
        Random random = new Random();
        for (int i = 0; i < MAGNITUDE; i++) {
            arr[i] = random.nextInt(MAGNITUDE);
        }
        return arr;
    }
}
