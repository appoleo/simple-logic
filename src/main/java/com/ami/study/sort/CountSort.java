package com.ami.study.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 计数排序
 *
 * @author wangchendong
 * @date 2021/02/02
 */
public class CountSort extends MySort {

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 2, 4, 1, 9, 5, 7};
        print(sort(arr));
    }

    /**
     * todo 实现稳定性
     *
     * @param arr array to sort
     * @return sorted
     */
    static int[] sort(int[] arr) {
        // 计算最小边界和区间
        int min = findMin(arr);
        int max = findMax(arr);
        int length = max - min + 1;

        int[] result = new int[arr.length];
        int[] count = new int[length];
        for (int item : arr) {
            count[item - min]++;
        }
        for (int i = 0, j = 0; i < count.length; i++) {
            while (count[i]-- > 0) result[j++] = i + min;
        }
        return result;
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


    @Test
    public void testCountSort() {
        int[] arr = new int[10000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10) + 8;
        }
        int[] result = sort(arr);
        Arrays.sort(arr);

        boolean same = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != result[i]) {
                same = false;
                break;
            }
        }

        Assert.assertSame(true, same);
    }
}
