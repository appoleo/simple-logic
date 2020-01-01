package com.ami.study.logic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * @author appoleo
 */
public class OptionalTest {

    public static void main(String[] args) {
        Emp emp = new Emp("xiaoMing", "上海", "11");
        Optional<Emp> op = Optional.ofNullable(emp);
        System.out.println(op.get().getAddress()); // 上海
        Optional<Emp> op1 = Optional.ofNullable(null);
        System.out.println(op1.orElse(emp).getAddress()); // 上海
        /*
         * 这里指定了一个默认对象emp，为先创建的一个emp对象，emp对象里的成员变量还没有复制，所以输出为null
         */
        System.out.println(op1.orElseGet(Emp::new).getAddress());
        try {
            System.out.println(op1.orElseThrow(RuntimeException::new));// java.lang.RuntimeException
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(op1.get().getAddress()); // java.util.NoSuchElementException
        } catch (Exception e) {
            e.printStackTrace();
        }
        String address = op.filter(obj -> obj.getAddress().equals("上海")).map(str -> str.getAddress()).get();
        System.out.println(address); // 上海

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Emp {

        private String name;

        private String address;

        private String age;

    }

}
