package com.ami.study.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangchendong
 * @date 2021/03/03
 */
public class BaseLogic {

    public static void main(String[] args) {
        Node<Integer> head = initNode();
        print(head);
    }

    private static Node<Integer> initNode() {
        Node<Integer> node10 = new Node<>(6, null);
        Node<Integer> node9 = new Node<>(7, node10);
        Node<Integer> node8 = new Node<>(10, node9);
        Node<Integer> node7 = new Node<>(5, node8);
        Node<Integer> node6 = new Node<>(3, node7);
        Node<Integer> node5 = new Node<>(2, node6);
        Node<Integer> node4 = new Node<>(6, node5);
        Node<Integer> node3 = new Node<>(9, node4);
        Node<Integer> node2 = new Node<>(1, node3);
        return new Node<>(4, node2);
    }

    private static <T> void print(Node<T> head) {
        if (head == null) return;
        Node<T> pos = head;
        while (pos != null) {
            System.out.print(pos.value + " ");
            pos = pos.next;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Node<T> {

        private T value;

        private Node<T> next;
    }
}
