package com.ami.study.logic;

import org.junit.Test;

/**
 * @author appoleo
 */
public class StaticTest {

    private static long counter = 0;

    private final long id = counter++;

    public StaticTest() {
        System.out.println(id);
    }

    @Test
    public void testFinal2() {
        new StaticTest();
        new StaticTest();
        new StaticTest();
        System.out.println(id);
        counter++;
        System.out.println(id);
    }

    @Test
    public void testFinal() throws InterruptedException {
        new StaticTest();
        new StaticTest();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(counter);
        }).start();
        counter = 10;
        Thread.sleep(3000);
    }

}
