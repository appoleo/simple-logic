package com.ami.study.logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/**
 * @author appoleo
 */
public class SimpleLogicTest {

    /*public static void main(String[] args) {
        Dichotomy dichotomy = new Dichotomy();
        int squareBoot = dichotomy.getSquareBoot(1);
        System.out.println(squareBoot);
    }*/

    /*public static void main(String[] args) {
        char[] letters = {'c', 'e', 'f', 'h', 'x'};
        Dichotomy dichotomy = new Dichotomy();
        char e = dichotomy.getLetterLessThanTarget(letters, 'd');
        System.out.println(e);
    }*/

    /*public static void main(String[] args) {
        double epsinon = 0.0000000001;
        double sqrt2 = Dichotomy.sqrt2(epsinon);
        System.out.println(sqrt2);
    }*/

    /**
     * 递归算法（求n的加法组合，将一个整数拆分成多个整数相加的形式， O(N)时间，O(N)空间）
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<Integer> list = new LinkedList<>();
        new SimpleLogicTest().fun(num, list, 1);
    }

    /**
     * @param num   被分解的数字
     * @param list  分解后的数字
     * @param start 遍历时当前组合的第一个数字，这个数字用来去除重复，输出唯一性
     */
    private void fun(int num, List<Integer> list, int start) {
        if (num == 1) {
            print(list);
            System.out.println(1);
        } else {
            for (int i = start; i <= num / 2; i++) {
                list.add(i);
                fun(num - i, list, i);
                list.remove(list.size() - 1);
            }
            print(list);
            System.out.println(num);
        }
    }

    private void print(List<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + " + ");
        }
    }
}
