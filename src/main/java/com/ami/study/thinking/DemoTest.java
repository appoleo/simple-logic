package com.ami.study.thinking;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangchendong
 */
@Slf4j
public class DemoTest {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        // System.out.println(str1);
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        // System.out.println(str2);
        System.out.println(str2.intern() == str2);
    }
}
