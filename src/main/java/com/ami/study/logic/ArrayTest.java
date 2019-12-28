package com.ami.study.logic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author appoleo
 */
@SuppressWarnings({"UnusedReturnValue", "ResultOfMethodCallIgnored"})
public class ArrayTest {

    /**
     * how to find the element in array
     */
    public static void main(String[] args) {
        // String[] arr = new String[]{"沉", "默", "王", "二", "真牛逼"};
        String[] arr = new String[1000];
        Random s = new Random();
        for (int i = 0; i < 1000; i++) {
            arr[i] = String.valueOf(s.nextInt());
        }
        // 使用list
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useList(arr, "真牛逼");
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("useList " + duration/1000000);
        // 使用set
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useSet(arr, "真牛逼");
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("useSet " + duration/1000000);
        // 使用循环
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useLoop(arr, "真牛逼");
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("useLoop " + duration/1000000);
        // 使用stream
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useStream(arr, "真牛逼");
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("useStream " + duration/1000000);
    }

    private static boolean useStream(String[] arr, String targetValue) {
        return Stream.of(arr).noneMatch(s -> s.equals(targetValue));
    }

    public static boolean useList(String[] arr, String targetValue) {
        return Arrays.asList(arr).contains(targetValue);
    }

    public static boolean useSet(String[] arr, String targetValue) {
        HashSet<String> set = new HashSet<>(Arrays.asList(arr));
        return set.contains(targetValue);
    }

    public static boolean useLoop(String[] arr, String targetValue) {
        for (String s : arr) {
            if (s == null) {
                return targetValue == null;
            }
            if (s.equals(targetValue)) {
                return true;
            }
        }
        return false;
    }

}
