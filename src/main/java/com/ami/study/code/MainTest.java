package com.ami.study.code;

import java.util.ArrayList;

/**
 * @author wangchendong
 * @date 2021/05/13
 */
public class MainTest {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println();
        list.add(1);
        System.out.println(list);
        list.removeIf(item -> item == 1);
        System.out.println(list);
        System.out.println("-------");
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j);
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println("-------");
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i <= j) {
                    System.out.print(i + "*" + j + "=" + i * j);
                    System.out.print("\t");
                } else {
                    System.out.print("\t\t");
                }
            }
            System.out.println();
        }
    }

    private String test;

    private volatile static MainTest mainTest;

    public static MainTest getSingleInstance() {
        if (mainTest == null) {
            synchronized(MainTest.class) {
                if (mainTest == null) {
                    mainTest = new MainTest();
                }
            }
        }
        return mainTest;
    }


}
