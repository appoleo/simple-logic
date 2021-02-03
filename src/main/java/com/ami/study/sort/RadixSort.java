package com.ami.study.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 基数排序
 *
 * @author wangchendong
 * @date 2021/02/02
 */
public class RadixSort extends MySort {

    public static void main(String[] args) {
        int[] arr = {421, 240, 115, 532, 305, 430, 124};
        int[] result = sort(arr);
        print(result);
    }

    /**
     * O(n * k)
     * 内部调用计数排序
     * todo 完善外层for循环次数动态变化
     *
     * @param arr array to sort
     * @return sorted
     */
    private static int[] sort(int[] arr) {
        int[] result = new int[arr.length];
        int[] count = new int[10];

        for (int i = 0; i < 3; i++) {
            int division = (int) Math.pow(10, i);
            for (int k : arr) {
                int num = k / division % 10;
                count[num]++;
            }

            for (int j = 1; j < count.length; j++) {
                count[j] += count[j - 1];
            }

            for (int j = arr.length - 1; j >= 0; j--) {
                result[--count[arr[j] / division % 10]] = arr[j];
            }

            System.arraycopy(result, 0, arr, 0, arr.length);
            Arrays.fill(count, 0);
        }

        return arr;
    }

    @Test
    public void testRadixSort() {
        int[] arr = new int[10000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(900) + 100;
        }
        int[] arrCopy = new int[arr.length];
        System.arraycopy(arr, 0, arrCopy, 0, arr.length);

        Arrays.sort(arr);
        int[] result = sort(arrCopy);

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
