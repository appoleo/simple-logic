package com.ami.study.logic;

import java.math.BigInteger;
import java.time.LocalDate;

/**
 * @author wangchendong
 * @date 2021/08/12
 */
public class MathUtil {

    public static void main(String... args)  {

    }

    /**
     * 快速幂
     *
     * @param x   正数
     * @param cnt 指数
     * @return x的cnt次方
     */
    private static long quickPow(int x, int cnt) {
        long res = 1;
        long temp = x;
        while (cnt > 0) {
            if ((cnt & 1) == 1) {
                res *= temp;
            }
            temp *= temp;
            cnt >>= 1;
        }
        return res;
    }

    private static long pow(int x, int cnt) {
        long res = 1;
        while (cnt > 0) {
            res *= x;
            cnt--;
        }
        return res;
    }

    /**
     * 辗转相除法求最大公约数
     *
     * @param a 正数a
     * @param b 正数b
     * @return a、b两数的最大公约数
     * @see BigInteger#gcd(java.math.BigInteger)
     */
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static int getMonday() {
        int ans = 0;
        LocalDate start = LocalDate.of(1901, 1, 1); // 起点
        LocalDate end = LocalDate.of(2000, 12, 31); // 终点
        while (start.compareTo(end) <= 0) { // 只要再起点终点之间都要计算
            if (start.getDayOfWeek().getValue() == 1) { // 如果星期一
                ans++;
                start = start.plusDays(7);
            } else {
                start = start.plusDays(1); // 往后一天
                continue;
            }
            while (start.compareTo(end) <= 0) {
                ans++;
                start = start.plusDays(7);
            }
            break;
        }
        return ans;
    }
}
