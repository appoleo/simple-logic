package com.ami.study.thinking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author appoleo
 */
public class Operator {

    boolean flag;

    @Test
    public void StringTest() {
        // boolean flag = false;
        String word = "hello";
        System.out.println(word + flag);
    }

    char c1;

    @Test
    public void literals() {
        int i1 = 0x2f;
        System.out.println(i1);
        int i2 = 0177;
        System.out.println(i2);
        System.out.println(Integer.toBinaryString(i2));
        char c = 0x0000;
        System.out.println(c);
        System.out.println(Integer.toBinaryString(c));
        System.out.println(c1);
    }

    @Test
    public void exponent() {
        System.out.println(Math.E);
    }

    @Test
    public void bitOperation() {
        boolean b = false ^ true;
        System.out.println(b);
        System.out.println(~7);
        System.out.println();
    }

    @Test
    public void booleanTest() {
        boolean a = false;
        boolean b = true;
        while (a = b) { // 无限循环
            System.out.println(1);
        }
    }

    public void optionalTest() {
        List<String> list = new ArrayList<>();
        
    }
}
