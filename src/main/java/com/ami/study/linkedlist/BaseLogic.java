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
        // print(head);
        System.out.println();
        System.out.println("is ring: " + isRing(head));
        Node<Integer> enteringNode = nodeEnteringRing(head);
        System.out.println("node entering ring: " + (enteringNode == null ? null : enteringNode.getValue()));
    }

    /**
     * 判断链表是否有环
     *
     * @return 有 true  没有 false
     */
    private static <T> boolean isRing(Node<T> head) {
        Node<T> slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    /**
     * 获取入环节点
     *
     * @return 如果有环，返回入环节点，否则返回null
     */
    private static <T> Node<T> nodeEnteringRing(Node<T> head) {
        Node<T> slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * 两个链表是否相交
     */
    private static boolean isIntersect(Node<Integer> node1, Node<Integer> node2) {
        if (node1 == null || node2 == null) return false;
        // 先判断是否有环
        boolean ring1 = isRing(node1);
        boolean ring2 = isRing(node2);
        if (ring1 != ring2) return false;
        // 根据是否有环分别做判断
        if (ring1) {
            // 如果有环，入环节点相同，则true，如果环相同，则true
            Node<Integer> integerNode1 = nodeEnteringRing(node1);
            Node<Integer> integerNode2 = nodeEnteringRing(node2);
            if (integerNode1 == integerNode2) return true;
            Node<Integer> next = integerNode1;
            assert next != null;
            while (next.next != integerNode2) {
                next = next.next;
                if (next == integerNode1) {
                    return false;
                }
            }
            return true;
        } else {
            // 如果没有环，判断最后一个节点是否相等
            Node<Integer> last1 = node1, last2 = node2;
            while (last1.next != null) last1 = last1.next;
            while (last2.next != null) last2 = last2.next;
            return last1 == last2;
        }
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
        node10.next = node7;
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
