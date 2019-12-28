package com.ami.study.thinking.extend;

/**
 * @author appoleo
 */
public class Animal {

    private void eat() {
        System.out.println("private eat");
    }

    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.eat();
    }

}
