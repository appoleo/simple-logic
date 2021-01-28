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

    public static void main(String[] args) {
        int[] arr = getRandomArr();
        int[] arrCopy = new int[arr.length];
        System.arraycopy(arr, 0, arrCopy, 0, arr.length);
        // SelectionSort.sort(arr);
        // BubbleSort.sort(arr);
        // BubbleSort.sortOptimize(arr);
        // InsertionSort.sort(arr);
        ShellSort.sort(arr);

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
        int[] arr = new int[100000];
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            arr[i] = random.nextInt(100000);
        }
        return arr;
    }
}
