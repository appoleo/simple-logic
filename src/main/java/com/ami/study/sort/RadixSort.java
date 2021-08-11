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
        // 存放各个位数上的数字出现的次数，并计算出右边界
        int[] count = new int[10];
        // 获取最大位数
        int max = findMax(arr);
        int numLength = getNumLength3(max);
        // 根据最大位数进行遍历，依次对个位、十位...进行排序
        for (int i = 0; i < numLength; i++) {
            int division = (int) Math.pow(10, i);
            // 计算该位出现次数
            for (int k : arr) {
                int num = k / division % 10;
                count[num]++;
            }
            // 计算该位在arr中右边界
            for (int j = 1; j < count.length; j++) {
                count[j] += count[j - 1];
            }
            // 由右向左排序
            for (int j = arr.length - 1; j >= 0; j--) {
                result[--count[arr[j] / division % 10]] = arr[j];
            }
            // 按该位排序好的序列复制到结果中
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
            arr[i] = random.nextInt(1000);
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
