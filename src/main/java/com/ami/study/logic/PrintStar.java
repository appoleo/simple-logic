package com.ami.study.logic;

import java.util.Random;
import java.util.Scanner;

/**
 * 输入一个正整数n（暂不考虑非法输入），输出需求样式内容（参照下面示例）
 * 随机生成n个整数[1~10]，打印索引，由0开始，最大为9，再复位到0开始
 * 每个索引对应的列上打印对应随机数字个数的“*”
 * 索引与*之间用“-”隔开
 *
 * @author appoleo
 *
 * 示例1：
 *     元素个数n：8
 *           *       * 
 *       *   *       * 
 *       *   *       * 
 *       *   *     * * 
 *       *   *     * * 
 *       * * *     * * 
 *       * * *     * * 
 *     * * * * * * * * 
 *     ---------------
 *     0 1 2 3 4 5 6 7 
 *     
 * 示例2：
 *     元素个数n：28
 *     *     *   *                                           * 
 *     *     *   *   *                               *       * 
 *     *     *   *   *                           *   * *     * 
 *     *     *   *   *         *                 *   * *     * 
 *     *     *   *   *   *     * *               * * * *     * 
 *     * *   *   *   *   *     * *     *     *   * * * * *   * 
 *     * * * *   *   * * *     * *     *   * *   * * * * *   * 
 *     * * * *   *   * * *   * * *   * * * * *   * * * * *   * 
 *     * * * * * *   * * *   * * *   * * * * *   * * * * *   * 
 *     * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 *     -------------------------------------------------------
 *     0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 
 */

public class PrintStar {
    public static void main(String[] args) {

        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.print("元素个数n：");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(10) + 1;
        }

        // “*”的行数为数组最大元素值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[0]<arr[i]){
                max = arr[i];
            }
        }

        // 外层循环控制行数，内层循环控制打印内容
        for (int i = max; i > 0; i--) {
            for (int k : arr) {
                if (k >= i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        // 控制‘-’的打印
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println("-");
            } else {
                System.out.print("--");
            }
        }

        // 打印索引
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i % 10 + " ");
        }

    }
}