package com.ami.study.thinking;

import lombok.extern.slf4j.Slf4j;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author wangchendong
 */
@Slf4j
public class DemoTest {

    class GrandFather {
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFather {
        void thinking() {
            System.out.println("i am father");
        }
    }

    class Son extends Father {
        void thinking() {
            // 请读者在这里填入适当的代码（不能修改其他地方的代码）
            // 实现调用祖父类的thinking()方法，打印"i am grandfather"
            try {
                MethodType methodType = MethodType.methodType(void.class);
                MethodHandle methodHandle = MethodHandles.lookup()
                        .findSpecial(GrandFather.class, "thinking", methodType, getClass());

                // MethodType methodType = MethodType.methodType(void.class);
                // Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                // lookupImpl.setAccessible(true);
                // MethodHandle methodHandle = ((MethodHandles.Lookup) lookupImpl.get(null))
                //         .findSpecial(GrandFather.class, "thinking", methodType, GrandFather.class);
                methodHandle.invoke(this);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new DemoTest().new Son().thinking();
    }
}