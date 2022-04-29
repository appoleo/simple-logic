package com.ami.study.framework.future;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author wangchendong
 */
public class CompletableFutureDemo {

    static CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    });

    private static void demo1() throws ExecutionException, InterruptedException {

        System.out.println(completableFuture.get());
        System.out.println(completableFuture.complete(2));
        System.out.println(completableFuture.get());
    }

    // public static void main(String[] args) throws Exception {
    //     // demo1();
    //     // TimeUnit.SECONDS.sleep(5);
    //     demo2();
    // }

    static int getMoreData() {
        System.out.println("begin to start compute");
        long millis = System.currentTimeMillis();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end to start compute. passed " + (System.currentTimeMillis() - millis)/1000 + " seconds");
        return new Random().nextInt(1000);
    }
    public static void demo2() throws ExecutionException, InterruptedException, IOException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(CompletableFutureDemo::getMoreData);
        Future<Integer> f = future.whenComplete((v, e) -> {
            System.out.println(v);
            System.out.println(e);
        });
        System.out.println(f.get());
        System.in.read();
    }

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> f1 = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "123";
                });
        CompletableFuture<String> f2 = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(8);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "456";
                });
        CompletableFuture<String> f3 = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "789";
                });

        CompletableFuture.allOf(f1, f2, f3).join();

        System.out.println(f1.get() + f2.get() + f3.get());

    }
}
